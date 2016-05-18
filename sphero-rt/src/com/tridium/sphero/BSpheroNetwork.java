/**

 */
package com.tridium.sphero;

//import javax.baja.license.Feature;
import javax.baja.naming.BOrd;
import javax.baja.sys.*;
import javax.baja.util.Lexicon;
import javax.baja.nre.annotations.*;

import com.tridium.ndriver.BNNetwork;
import com.tridium.ndriver.comm.*;
import com.tridium.ndriver.datatypes.*;
import com.tridium.ndriver.discover.*;
import com.tridium.ndriver.poll.*;
import com.tridium.sphero.comm.SpheroListener;
import com.tridium.sphero.comm.BSpheroSerialCommConfig;



/**
 *  BSpheroNetwork models a network of devices
 *
 *  @author   Robert Adams
 *  @creation 28-Apr-16 
 */
@NiagaraType
@NiagaraProperty(name = "pollScheduler", type = "BNPollScheduler",  defaultValue = "new BNPollScheduler()")
@NiagaraProperty(name = "serialConfig", type = "BSpheroSerialCommConfig",  defaultValue = "new BSpheroSerialCommConfig()")
@NiagaraProperty(name = "localDevice", type = "BSpheroDevice",  defaultValue = "new BSpheroDevice()")
public class BSpheroNetwork
  extends BNNetwork
{

/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.tridium.sphero.BSpheroNetwork(1930623405)1.0$ @*/
/* Generated Thu Apr 28 17:22:02 EDT 2016 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "pollScheduler"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code pollScheduler} property.
   * @see #getPollScheduler
   * @see #setPollScheduler
   */
  public static final Property pollScheduler = newProperty(0, new BNPollScheduler(), null);
  
  /**
   * Get the {@code pollScheduler} property.
   * @see #pollScheduler
   */
  public BNPollScheduler getPollScheduler() { return (BNPollScheduler)get(pollScheduler); }
  
  /**
   * Set the {@code pollScheduler} property.
   * @see #pollScheduler
   */
  public void setPollScheduler(BNPollScheduler v) { set(pollScheduler, v, null); }

////////////////////////////////////////////////////////////////
// Property "serialConfig"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code serialConfig} property.
   * @see #getSerialConfig
   * @see #setSerialConfig
   */
  public static final Property serialConfig = newProperty(0, new BSpheroSerialCommConfig(), null);
  
  /**
   * Get the {@code serialConfig} property.
   * @see #serialConfig
   */
  public BSpheroSerialCommConfig getSerialConfig() { return (BSpheroSerialCommConfig)get(serialConfig); }
  
  /**
   * Set the {@code serialConfig} property.
   * @see #serialConfig
   */
  public void setSerialConfig(BSpheroSerialCommConfig v) { set(serialConfig, v, null); }

////////////////////////////////////////////////////////////////
// Property "localDevice"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code localDevice} property.
   * @see #getLocalDevice
   * @see #setLocalDevice
   */
  public static final Property localDevice = newProperty(0, new BSpheroDevice(), null);
  
  /**
   * Get the {@code localDevice} property.
   * @see #localDevice
   */
  public BSpheroDevice getLocalDevice() { return (BSpheroDevice)get(localDevice); }
  
  /**
   * Set the {@code localDevice} property.
   * @see #localDevice
   */
  public void setLocalDevice(BSpheroDevice v) { set(localDevice, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpheroNetwork.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public void started()
      throws Exception
  {
    super.started();
  
    getSerialConfig().setDefaultListener(new SpheroListener(getSerialConfig()));
  
   
  }

  /** Specify name for network resources. */
  public String getNetworkName() { return "SpheroNetwork"; }

  /** return device folder type  */
  @Override
  public Type getDeviceFolderType()
  {
    return BSpheroDeviceFolder.TYPE;
  }

  /** return device type */
  @Override
  public Type getDeviceType()
  {
    return BSpheroDevice.TYPE;
  }
  
  /** TODO - Add license check if needed
  @Override
  public final Feature getLicenseFeature()
  {
    return Sys.getLicenseManager().getFeature("?? vendor", "?? feature");
  }
  */
  
  @Override
  public void changed(Property p, Context cx)
  {
    super.changed(p, cx);
    if(!isRunning()) return;

    if(p == status)
    {
      // Give any comms opportunity to respond to status changes
      getSerialConfig().statusUpdate();
  
    }
  }
  

  
  
////////////////////////////////////////////////////////////////
//Utilities
////////////////////////////////////////////////////////////////
  
  
  
   
   /**Access the serial comm stack */
  public NComm scomm()
  {
    return (NComm)getSerialConfig().comm();
  }
  
  
  public static Lexicon LEX = Lexicon.make(BSpheroNetwork.class);

}
