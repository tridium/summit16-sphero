/**
 *
 */
package com.tridium.sphero.datatypes;

import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BFacets;
import javax.baja.sys.BStruct;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.units.BDimension;
import javax.baja.units.BUnit;
import javax.baja.units.UnitDatabase;

/**
 *  BRollParameters
 *
 * @author Robert Adams
 * @creation Mar 17, 2014
 *
 */
@NiagaraType
@NiagaraProperty(name = "speed", type = "int", defaultValue = "0",
  facets =
  {
    @Facet(name = BFacets.UNITS, value = "BUnit.getUnit(\"meters per minute\")"),
    @Facet(name = BFacets.MIN, value = "0"),
    @Facet(name = BFacets.MAX, value = "255"),
    @Facet(name = BFacets.RADIX, value = "10")
  }
)
@NiagaraProperty(name = "heading", type = "int", defaultValue = "0",
  facets =
    {
      @Facet(name = BFacets.UNITS, value = "BUnit.getUnit(\"degrees angular\")"),
      @Facet(name = BFacets.MIN, value = "0"),
      @Facet(name = BFacets.MAX, value = "359"),
      @Facet(name = BFacets.RADIX, value = "10")
    }
)
public class BRollParameters
    extends BStruct
{

  
 // class BRollParameters
 // {
 //   properties
 //   {
 //     speed : int
 //       default {[ 0 ]}
 //       slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("meters per minute"), 1, 0, 255) ]}
 //
 //     heading : int
 //       default {[ 0 ]}
 //       slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("degrees angular"), 1, 0, 359)]}
 //    }
 // }





/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.tridium.sphero.datatypes.BRollParameters(557678232)1.0$ @*/
/* Generated Tue May 03 14:11:01 EDT 2016 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "speed"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code speed} property.
   * @see #getSpeed
   * @see #setSpeed
   */
  public static final Property speed = newProperty(0, 0, BFacets.make(BFacets.make(BFacets.make(BFacets.make(BFacets.UNITS, BUnit.getUnit("meters per minute")), BFacets.make(BFacets.MIN, 0)), BFacets.make(BFacets.MAX, 255)), BFacets.make(BFacets.RADIX, 10)));
  
  /**
   * Get the {@code speed} property.
   * @see #speed
   */
  public int getSpeed() { return getInt(speed); }
  
  /**
   * Set the {@code speed} property.
   * @see #speed
   */
  public void setSpeed(int v) { setInt(speed, v, null); }

////////////////////////////////////////////////////////////////
// Property "heading"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code heading} property.
   * @see #getHeading
   * @see #setHeading
   */
  public static final Property heading = newProperty(0, 0, BFacets.make(BFacets.make(BFacets.make(BFacets.make(BFacets.UNITS, BUnit.getUnit("degrees angular")), BFacets.make(BFacets.MIN, 0)), BFacets.make(BFacets.MAX, 359)), BFacets.make(BFacets.RADIX, 10)));
  
  /**
   * Get the {@code heading} property.
   * @see #heading
   */
  public int getHeading() { return getInt(heading); }
  
  /**
   * Set the {@code heading} property.
   * @see #heading
   */
  public void setHeading(int v) { setInt(heading, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BRollParameters.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
      

  public BRollParameters() {}
  public BRollParameters(int speed, int heading)
  {
    setSpeed(speed);
    setHeading(heading);
  }
}
