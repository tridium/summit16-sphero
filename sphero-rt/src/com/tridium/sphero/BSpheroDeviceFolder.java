/*

 */
package com.tridium.sphero;

import javax.baja.sys.*;
import javax.baja.nre.annotations.*;

import com.tridium.ndriver.BNDeviceFolder;

/**
 * BSpheroDeviceFolder is a folder for BSpheroDevice.
 *
 *  @author   Robert Adams
 *  @creation 28-Apr-16 
 */
@NiagaraType
public class BSpheroDeviceFolder
  extends BNDeviceFolder
{                       

/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.tridium.sphero.BSpheroDeviceFolder(2979906276)1.0$ @*/
/* Generated Thu Apr 28 17:25:31 EDT 2016 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpheroDeviceFolder.class);

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
   * @return true if parent is BSpheroNetwork or BSpheroDeviceFolder.
   */
  public boolean isParentLegal(BComponent parent)
  {
    return parent instanceof BSpheroNetwork ||
           parent instanceof BSpheroDeviceFolder;
  }


}
