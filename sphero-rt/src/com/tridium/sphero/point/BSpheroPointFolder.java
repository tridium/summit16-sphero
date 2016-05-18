/**

 */
package com.tridium.sphero.point;

import javax.baja.sys.*;
import javax.baja.driver.point.*;

import com.tridium.sphero.*;
import javax.baja.nre.annotations.*;

/**
 * BSpheroPointFolder
 *
 * @author   Robert Adams
 * @creation 28-Apr-16  
 */
@NiagaraType
public class BSpheroPointFolder
  extends BPointFolder
{            

/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.tridium.sphero.point.BSpheroPointFolder(2979906276)1.0$ @*/
/* Generated Thu Apr 28 17:23:32 EDT 2016 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpheroPointFolder.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

////////////////////////////////////////////////////////////////
// Access
////////////////////////////////////////////////////////////////
  
  /**
   * Get the network cast to a BSpheroNetwork.
   * @return network as a BSpheroNetwork.
   */
  public final BSpheroNetwork getSpheroNetwork()
  {
    return (BSpheroNetwork)getNetwork();
  }

  /**
   * Get the device cast to a BSpheroDevice.
   * @return device as a BSpheroDevice.
   */
  public final BSpheroDevice getSpheroDevice()
  {
    return (BSpheroDevice)getDevice();
  }

}
