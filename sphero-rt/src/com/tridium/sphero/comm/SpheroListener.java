/**

 */
package com.tridium.sphero.comm;

import com.tridium.ndriver.comm.ICommListener;
import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.datatypes.BCommConfig;


/**
 * SpheroListener processes unsolicited messages.
 *
 * @author   Robert Adams
 * @creation 28-Apr-16 
 *
 */
public class SpheroListener
  implements ICommListener
{
  
  /** Constructor */
  public SpheroListener(BCommConfig ccfg) {}

  /**
   * Customized to process the unsolicited message for this driver. <p>
   * @param nMsg message received from panel
   */
  public void receiveMessage(NMessage nMsg)
  {    
    // TODO
  }
  

}
