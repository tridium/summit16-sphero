/**
 */
package com.tridium.sphero.message;

import com.tridium.ndriver.comm.IMessageFactory;
import com.tridium.ndriver.comm.LinkMessage;
import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.io.TypedInputStream;
import com.tridium.sphero.comm.SpheroLinkMessage;


/**
 * SpheroMessageFactory implementation of IMessageFactory.
 *
 * @author   Robert Adams
 * @creation 17-Mar-14 
 */
public class SpheroMessageFactory
  implements IMessageFactory
{
  
  public SpheroMessageFactory() {}
  
  public NMessage makeMessage(LinkMessage lm) 
      throws Exception
  {
    SpheroLinkMessage slm = (SpheroLinkMessage)lm;
    
    if(slm.sop2 == 0xFF && slm.dlen==0)
    {
      // simple response - no data
      return new AcknowledgeMsg(slm.seq);
    }
    
    TypedInputStream ti = new TypedInputStream(slm.getByteArray(),0,slm.dlen);
    if(slm.sop2 == 0x0FF)
    {
      return new ResponseMsg(slm.msgByte, slm.seq, slm.dlen, ti);
    }
    else if(slm.sop2 == 0x0FE)
    {
      return new AsynchronousMsg(slm.dlen, ti);
    }

    System.out.println("Unknown message types:" + slm.sop2);
    
    ti.close();
    return null;
  }

}
