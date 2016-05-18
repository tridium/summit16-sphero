/**
 *
 */
package com.tridium.sphero.message;


/**
 *  Ping message
 *
 * @author Robert Adams
 * @creation Mar 17, 2014
 *
 */
public class SpheroPing
    extends CommandMsg
{

  /**
   * 
   */
  public SpheroPing()
  {
    super(DEVICE_ID_CORE, MSG_ID_PING);
  }
  
  protected int getDataLength() { return 0; }

}
