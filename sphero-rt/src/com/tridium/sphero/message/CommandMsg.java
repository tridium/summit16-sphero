/**
 *
 */
package com.tridium.sphero.message;

import java.io.OutputStream;

import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.io.TypedOutputStream;

/**
 *  CommandMsg is base class for Sphero command messages.
 *
 * @author Robert Adams
 * @creation Mar 17, 2014
 *
 */
public abstract class CommandMsg
    extends SpheroMessage
{

  /**
   * 
   */
  public CommandMsg(int did, int cid)
  {
    super(getNextSequence());
    this.did = did;
    this.cid = cid;
  }
  
  
  //Override for outgoing messages
  public boolean toOutputStream(OutputStream out) 
    throws Exception
  {
    // Use typed stream for more readable code.   
    TypedOutputStream to = (TypedOutputStream)out;
    
    to.writeUnsigned8(0x0ff);
    to.writeUnsigned8(getSP2());
    
    // All outgoing messages use requests format
    to.writeUnsigned8(did);
    to.writeUnsigned8(cid);
    to.writeUnsigned8(seq);
    
    to.writeUnsigned8(getDataLength()+1); // add one to cover checksum
    dataOut(to);
    // checkSum added in SpheroLinkMessage which alone calls this method

    return false;
  }
  
  public int validateResponse(NMessage msg) 
      throws Exception
  {
    if(((SpheroMessage)msg).isAck()) 
    {
      return ACK_SUCCESS_RESPONSE;
    }
    
    return SUCCESS_RESPONSE;
  }

  
  protected int getSP2()
  {
    int sp2 = 0x0fc;
    if(answer) sp2 |= 0x01;
    if(isResetTimeout()) sp2 |= 0x02; 
    return sp2;
    
  }
  
  protected boolean isRequest() { return false; }

  // Always use reset timeout
  protected boolean isResetTimeout() { return true; }
  
  protected abstract int getDataLength();
  protected void dataOut(TypedOutputStream to) {}
  
  private static int getNextSequence()
  {
    nxtSeq +=1;
    if(nxtSeq > 0x0ff) nxtSeq = 1;
System.out.println("getNextSequence() returns " + nxtSeq);
    return nxtSeq;
  } 
  
  static int nxtSeq = 1;
  boolean answer = true;
  int did = 0;
  int cid = 0;
  int seq = 0;

  public void toTraceString(StringBuffer sb)
  {
    sb.append(getClass().getName()).append("\n");
    sb.append("device:" + did + " cmd:" + cid + " seq:" + seq).append("\n");
  }

}
