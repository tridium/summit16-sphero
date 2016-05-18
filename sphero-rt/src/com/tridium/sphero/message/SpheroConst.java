/**
 *
 */
package com.tridium.sphero.message;

/**
 *  Constants
 *
 * @author Robert Adams
 * @creation Mar 17, 2014
 *
 */
public interface SpheroConst
{
  
  // from Orbotix Communication API 1.50
  public static final int DEVICE_ID_CORE = 0x00 ;
  public static final int DEVICE_ID_BOOTLOADER = 0x01 ;
  public static final int DEVICE_ID_SPHERO = 0x02 ;
  
  // Core device messages
  public static final int MSG_ID_PING = 0x01;
  public static final int MSG_ID_GET_VERSIONING = 0x02;
  
  // Sphero device messages
  public static final int MSG_ID_SET_HEADING = 0x01;
  public static final int MSG_ID_SET_STABILIZATION = 0x02;
  public static final int MSG_ID_ROLL = 0x030;

}
