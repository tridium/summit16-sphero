/**
 */
package com.tridium.sphero.comm;

import java.io.InputStream;
import java.io.OutputStream;

import com.tridium.ndriver.comm.LinkMessage;
import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.io.TypedOutputStream;

/**
 * SpheroLinkMessage streams data to and from a byte array representation.
 *
 * @author   Robert Adams
 * @creation 17-Mar-14 
 */
public class SpheroLinkMessage
  extends LinkMessage
{
  public SpheroLinkMessage(int maxLen)  { super(maxLen); }
  
  /** 
   * Get byte data from inputStream.
   *  return true if complete message received 
   */
  public boolean receive(InputStream in)
    throws Exception
  {
//    Log.getLog("sphero").trace("Receiving message:");
    OutputStream os = getOutputStream();
    
    // Ignore all input till start char
    while(in.read()!=START_BYTE);
    
    // Get second start byte
    sop2 = in.read();
    
    chksum = 0;
    seq = 0;
    msgByte = readChar(in);
    
    if(sop2 == 0x0ff)
    {
      // acknowledgement i.e. response?
      seq  = readChar(in);
      dlen = readChar(in);
    }
    else if(sop2 == 0x0fe)
    {
      // async
      // two byte len / no sequence
      dlen = readChar(in)<<8 + readChar(in);
    }
    else
    {
      return false;
    }
    
    // TODO - deal with special case of dlen==0xff for fixed data len msgs
    //int lenToRead = getDataLen(dlen);
    dlen -= 1; // don't read checksum with data
    // read data
    for(int i=0 ; i<dlen ; ++i)
    {
      os.write(readChar(in));
    }

    chksum = chksum % 256;  // modulo 256
    chksum = chksum ^ 0x0ff; // flip the bits

    int hisChksum = in.read();
    if(chksum!=hisChksum) System.out.println("expected checksum " + Integer.toString(chksum,16) + " rcvd " + Integer.toString(hisChksum,16));
    return true;
  }
  
  private int readChar(InputStream in)
      throws Exception
  {
    int c = in.read();
    chksum += c;
    return c;
  }
  
  public int sop2;
  public int msgByte;
  public int seq;
  public int dlen;
  int chksum;
  
  
  
////////////////////////////////////////////////////////////////
//Handle outgoing messages
////////////////////////////////////////////////////////////////

  /** Translate data from app message to link message representation */
  public boolean setMessage(NMessage msg)
    throws Exception
  {
    TypedOutputStream bos = new TypedOutputStream(512);//getByteArray());  TODO - fix this to wrap an outputStream
    msg.toOutputStream(bos);

    int chkLen = bos.size()-2; // Get total bytes less first two stop bytes
    byte[] msgArray = bos.toByteArray(); // access bytes to calc chkSum
    getOutputStream().write(msgArray);
    
    // calculate checksum
    int chkSum = 0;
    for(int i=0 ; i<chkLen ; ++i) 
    {
      chkSum += msgArray[i+2];
    }
    chkSum = chkSum % 256;  // modulo 256
    chkSum = chkSum ^ 0x0ff; // flip the bits
    getOutputStream().write(chkSum & 0xFF);   
    
    return false;
  }

 
  private static final int START_BYTE = 0x0FF;


}