/**

 */
package com.tridium.sphero.point;

import javax.baja.sys.*;

import javax.baja.agent.AgentList;
import javax.baja.driver.point.BPointDeviceExt;
import com.tridium.ndriver.util.AgentInfoUtil;



import com.tridium.sphero.*;
import javax.baja.nre.annotations.*;

/**
 * BSpheroPointDeviceExt is a container for sphero proxy points.
 *
 * @author   Robert Adams
 * @creation 28-Apr-16 
 */
@NiagaraType
public class BSpheroPointDeviceExt

  extends BPointDeviceExt 
{            



/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.tridium.sphero.point.BSpheroPointDeviceExt(2979906276)1.0$ @*/
/* Generated Thu Apr 28 17:23:32 EDT 2016 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpheroPointDeviceExt.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


  /**
   * Adds BNPointManager and renames.
   *
   * @see NAgentInfo.getAgentsHelp
   */
  public AgentList getAgents(Context cx)
  {
    AgentList agents = super.getAgents(cx);
    agents.add("ndriver:NPointManager");

    return AgentInfoUtil.getAgentsHelp(
        agents,
        getType().getTypeInfo().getModuleName(),
        "driver:PointManager",
        "PointManager",
        "Point Manager");
  }


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

////////////////////////////////////////////////////////////////
// PointDeviceExt
////////////////////////////////////////////////////////////////
  
  /**
   * @return the Device type.
   */
  public Type getDeviceType()
  {
    return BSpheroDevice.TYPE;
  }

  /**
   * @return the PointFolder type.
   */
  public Type getPointFolderType()
  {
    return BSpheroPointFolder.TYPE;
  }
  
  /**
   * @return the ProxyExt type.
   */
  public Type getProxyExtType()
  {
    return BSpheroProxyExt.TYPE;
  }
  

}
