/**
 *
 */
package com.tridium.sphero.message;

import com.tridium.ndriver.io.TypedInputStream;

/**
 *  AsynchronousMsg
 *
 * @author Robert Adams
 * @creation Mar 17, 2014
 *
 */
public class AsynchronousMsg
    extends SpheroMessage
{

  /**
   * 
   */
  public AsynchronousMsg(int dlen, TypedInputStream ti)
  {
    super(0);
    dataFromInput(dlen, ti);
  }
  
  public void dataFromInput(int dlen, TypedInputStream ti)
  {
    
  }

}
