/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.behavior.topview;

import org.allbinary.media.graphics.geography.map.MultiGeographicMapBehavior;
import org.allbinary.game.layer.AllBinaryTiledLayer;
import org.allbinary.game.physics.acceleration.GravityUtil;
import org.allbinary.game.physics.velocity.VelocityProperties;
import org.allbinary.layer.AllBinaryLayer;
import org.allbinary.media.graphics.geography.map.BasicGeographicMap;
import org.allbinary.media.graphics.geography.map.GeographicMapCellPosition;
import org.allbinary.media.graphics.geography.map.GeographicMapCellType;
import org.allbinary.media.graphics.geography.map.SimpleGeographicMapCellPositionFactory;

/**  *  * @author User  */
@groovy.transform.CompileStatic
public class GeographicMapTopViewGameLayerBehavior2 extends GeographicMapTopViewLayerBehavior {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private final GravityUtil gravityUtil = GravityUtil.getInstance();

    private final MultiGeographicMapBehavior geographicMapBehavior = new MultiGeographicMapBehavior();

    private final boolean autoStepBlocks;

    private final int offsetY;

    //public GeographicMapCellPosition blockGeographicMapCellPosition;
    private GeographicMapCellPosition previousGeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION;

    //    }
    public GeographicMapTopViewGameLayerBehavior2(final int maxGravityActionIndex, final boolean autoStepBlocks, final int offsetY) {
        super(maxGravityActionIndex);
        this.autoStepBlocks = autoStepBlocks;
        this.offsetY = offsetY;
    }

    @Override
    public void gravity(final VelocityProperties velocityProperties, final BasicGeographicMap[] geographicMapInterfaceArray, final GeographicMapCellType[] geographicMapCellTypeArray, final GeographicMapCellPosition geographicMapCellPosition) throws Exception {
        if (geographicMapCellPosition !== SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
            this.geographicMapBehavior.getCellTypeAt(geographicMapInterfaceArray, geographicMapCellTypeArray, geographicMapCellPosition);
            final boolean hasSolidBlock = this.hasSolidBlock(geographicMapInterfaceArray, geographicMapCellTypeArray);
            if (!hasSolidBlock) {
                //this.logUtil.putF(new StringMaker().append("Not on Block: ").append(geographicMapCellPosition).append(" cellType: ").append(cellType).toString(), this, "gravity");
                this.gravityUtil.process(velocityProperties, this.gravityUtil.@GAME_GRAVITY_VELOCITY);
                velocityProperties.limitXYToForwardAndReverseMaxVelocity();
                this.gravity();
            } else {
            }
        }
    }

    private GeographicMapCellPosition getPositionTopLeft(final BasicGeographicMap[] geographicMapInterfaceArray, final AllBinaryLayer layer, final int x, final int y) throws Exception {
        //                .toString(), this, "getGeographicMapCellPositionIfNotSolidBlockOrOffMap");
        final int xCellPosition = layer.getXP() + -x;
        final int yCellPosition = layer.getYP() + -y;
        return geographicMapInterfaceArray[0].getCellPositionAtXYNoThrow(xCellPosition, yCellPosition);
    }

    private GeographicMapCellPosition getPositionTopRight(final BasicGeographicMap[] geographicMapInterfaceArray, final AllBinaryLayer layer, final int x, final int y) throws Exception {
        //                .toString(), this, "getGeographicMapCellPositionIfNotSolidBlockOrOffMap");
        final int xCellPosition = layer.getXP() + -x + layer.getWidth();
        final int yCellPosition = layer.getYP() + -y;
        return geographicMapInterfaceArray[0].getCellPositionAtXYNoThrow(xCellPosition, yCellPosition);
    }

    private GeographicMapCellPosition getPositionBottomLeft(final BasicGeographicMap[] geographicMapInterfaceArray, final AllBinaryLayer layer, final int x, final int y) throws Exception {
        //                .toString(), this, "getGeographicMapCellPositionIfNotSolidBlockOrOffMap");
        final int xCellPosition = layer.getXP() + -x;
        final int yCellPosition = layer.getYP() + -y + layer.getHeight();
        return geographicMapInterfaceArray[0].getCellPositionAtXYNoThrow(xCellPosition, yCellPosition);
    }

    private GeographicMapCellPosition getPositionBottomRight(final BasicGeographicMap[] geographicMapInterfaceArray, final AllBinaryLayer layer, final int x, final int y) throws Exception {
        //                .toString(), this, "getGeographicMapCellPositionIfNotSolidBlockOrOffMap");
        final int xCellPosition = layer.getXP() + -x + layer.getWidth();
        final int yCellPosition = layer.getYP() + -y + layer.getHeight();
        return geographicMapInterfaceArray[0].getCellPositionAtXYNoThrow(xCellPosition, yCellPosition);
    }

    private GeographicMapCellPosition getLeftPosition(final BasicGeographicMap[] geographicMapInterfaceArray, final AllBinaryLayer layer) throws Exception {
        final int xCellPosition = layer.getXP();
        final int yCellPosition = layer.getYP() + layer.getHeight();
        return geographicMapInterfaceArray[0].getCellPositionAtXYNoThrow(xCellPosition, yCellPosition);
    }

    private GeographicMapCellPosition getRightPosition(final BasicGeographicMap[] geographicMapInterfaceArray, final AllBinaryLayer layer) throws Exception {
        final int xCellPosition = layer.getXP() + layer.getWidth();
        final int yCellPosition = layer.getYP() + layer.getHeight();
        return geographicMapInterfaceArray[0].getCellPositionAtXYNoThrow(xCellPosition, yCellPosition);
    }

    @Override
    public GeographicMapCellPosition getGeographicMapCellPositionIfNotSolidBlockOrOffMapLocation(final BasicGeographicMap[] geographicMapInterfaceArray, final GeographicMapCellType[] geographicMapCellTypeArray, final VelocityProperties velocityProperties, final AllBinaryLayer layer, final int x, int y) throws Exception {
        GeographicMapCellPosition geographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION;
        final GeographicMapCellPosition topLeftGeographicMapCellPosition = this.getPositionTopLeft(geographicMapInterfaceArray, layer, x, y);
        geographicMapCellPosition = this.getGeographicMapCellPositionIfNotSolidBlockOrOffMap(geographicMapInterfaceArray, geographicMapCellTypeArray, topLeftGeographicMapCellPosition, velocityProperties, layer);
        if (geographicMapCellPosition === SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
            //            }
            return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION;
        }
        final GeographicMapCellPosition topRightGeographicMapCellPosition = this.getPositionTopRight(geographicMapInterfaceArray, layer, x, y);
        geographicMapCellPosition = this.getGeographicMapCellPositionIfNotSolidBlockOrOffMap(geographicMapInterfaceArray, geographicMapCellTypeArray, topRightGeographicMapCellPosition, velocityProperties, layer);
        if (geographicMapCellPosition === SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
            //            }
            return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION;
        }
        final GeographicMapCellPosition bottomLeftGeographicMapCellPosition = this.getPositionBottomLeft(geographicMapInterfaceArray, layer, x, y);
        geographicMapCellPosition = this.getGeographicMapCellPositionIfNotSolidBlockOrOffMap(geographicMapInterfaceArray, geographicMapCellTypeArray, bottomLeftGeographicMapCellPosition, velocityProperties, layer);
        if (geographicMapCellPosition === SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
            //            }
            return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION;
        }
        final GeographicMapCellPosition bottomRightGeographicMapCellPosition = this.getPositionBottomRight(geographicMapInterfaceArray, layer, x, y);
        geographicMapCellPosition = this.getGeographicMapCellPositionIfNotSolidBlockOrOffMap(geographicMapInterfaceArray, geographicMapCellTypeArray, bottomRightGeographicMapCellPosition, velocityProperties, layer);
        if (geographicMapCellPosition === SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
        } else {
        }
        return geographicMapCellPosition;
    }

    @Override
    public GeographicMapCellPosition getGeographicMapCellPositionIfNotSolidBlockOrOffMap(final BasicGeographicMap[] geographicMapInterfaceArray, final GeographicMapCellType[] geographicMapCellTypeArray, final GeographicMapCellPosition geographicMapCellPosition, final VelocityProperties velocityProperties, final AllBinaryLayer layer) throws Exception {
        //this.previousGeographicMapCellPosition != geographicMapCellPosition && 
        if (geographicMapCellPosition !== SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
            final GeographicMapCellPosition possibleStepGeographicMapCellPosition = geographicMapCellPosition;
            //this.logUtil.putF(possibleStepGeographicMapCellPosition.toString(), this, "getGeographicMapCellPositionIfNotSolidBlockOrOffMap");
            final AllBinaryTiledLayer tiledLayer = geographicMapInterfaceArray[0].getAllBinaryTiledLayer();
            //this.logUtil.putF(new StringMaker().append("tileLayer: ").append(tiledLayer.getColumns()).append(CommonSeps.getInstance().COLON).append(tiledLayer.getRows()).toString(), this, "getGeographicMapCellPositionIfNotSolidBlockOrOffMap");
            if (possibleStepGeographicMapCellPosition.getColumn() > 0 && possibleStepGeographicMapCellPosition.getRow() > 0 && possibleStepGeographicMapCellPosition.getColumn() < tiledLayer.getColumns() && possibleStepGeographicMapCellPosition.getRow() < tiledLayer.getRows()) {
                this.geographicMapBehavior.getCellTypeAt(geographicMapInterfaceArray, geographicMapCellTypeArray, possibleStepGeographicMapCellPosition);
                final boolean hasSolidBlock = this.hasSolidBlock(geographicMapInterfaceArray, geographicMapCellTypeArray);
                final boolean hasOffMap = this.isOffMap(geographicMapInterfaceArray, geographicMapCellTypeArray);
                //|| basicPlatormGeographicMapCellTypeFactory.JUMP_THRU_CELL_TYPE.isType(cellType)
                if (hasSolidBlock || hasOffMap) {
                    //velocityProperties.getVelocityXBasicDecimalP().set(0);
                    this.previousGeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION;
                    return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION;
                } else {
                    //this.logUtil.putF("cellType: " + cellType, this, "getGeographicMapCellPositionIfNotSolidBlockOrOffMap");
                    this.previousGeographicMapCellPosition = possibleStepGeographicMapCellPosition;
                    return possibleStepGeographicMapCellPosition;
                }
            }
        } else {
        }
        //this.logUtil.putF("not moving", this, "getGeographicMapCellPositionIfNotSolidBlockOrOffMap");
        this.previousGeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION;
        return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION;
    }

    @Override
    public void moveAndLand(final BasicGeographicMap[] geographicMapInterfaceArray, final GeographicMapCellType[] geographicMapCellTypeArray, final GeographicMapCellPosition geographicMapCellPosition, final VelocityProperties velocityProperties, final AllBinaryLayer layer, final int x, final int y) throws Exception {
        //this.logUtil.putF(new StringMaker().append("x: ").append(x).append(" y: ").append(y).append(CommonSeps.getInstance().SPACE).append(layer.getViewPosition().getXP()).toString(), this, "moveAndLand");
        if (geographicMapCellPosition !== SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
            final TopViewCharacterInterface topViewCharacterInterface = (((TopViewCharacterInterface) layer));
            topViewCharacterInterface.terrainMove(geographicMapInterfaceArray, geographicMapCellTypeArray, x, y);
        } else {
        }
    }

    @Override
    public boolean move(final BasicGeographicMap[] geographicMapInterfaceArray, final GeographicMapCellType[] geographicMapCellTypeArray, final VelocityProperties velocityProperties, final AllBinaryLayer layer, final int x, final int y) throws Exception {
        final GeographicMapCellPosition geographicMapCellPosition = this.getGeographicMapCellPositionIfNotSolidBlockOrOffMapLocation(geographicMapInterfaceArray, geographicMapCellTypeArray, velocityProperties, layer, x, y);
        //this.gravity(velocityProperties, geographicMapInterfaceArray, geographicMapCellPosition);
        this.moveAndLand(geographicMapInterfaceArray, geographicMapCellTypeArray, geographicMapCellPosition, velocityProperties, layer, x, y);
        if (geographicMapCellPosition === SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void left(final BasicGeographicMap[] geographicMapInterfaceArray, final GeographicMapCellType[] geographicMapCellTypeArray, final VelocityProperties velocityProperties, final AllBinaryLayer layer) throws Exception {
        final GeographicMapCellPosition geographicMapCellPosition = this.getLeftPosition(geographicMapInterfaceArray, layer);
        if (geographicMapCellPosition !== SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
            final GeographicMapCellPosition possibleStepGeographicMapCellPosition = geographicMapInterfaceArray[0].getGeographicMapCellPositionFactory().getAt(geographicMapCellPosition.getColumn(), geographicMapCellPosition.getRow() - 1);
            this.geographicMapBehavior.getCellTypeAt(geographicMapInterfaceArray, geographicMapCellTypeArray, possibleStepGeographicMapCellPosition);
            final boolean hasSolidBlock = this.hasSolidBlock(geographicMapInterfaceArray, geographicMapCellTypeArray);
            if (hasSolidBlock) {
                if (this.autoStepBlocks) {
                    final TopViewCharacterInterface topViewCharacterInterface = (((TopViewCharacterInterface) layer));
                    topViewCharacterInterface.leftp();
                } else {
                    velocityProperties.getVelocityXBasicDecimalP().setint(0);
                }
            } else {
                final TopViewCharacterInterface topViewCharacterInterface = (((TopViewCharacterInterface) layer));
                topViewCharacterInterface.leftp();
            }
        }
    }

    @Override
    public void right(final BasicGeographicMap[] geographicMapInterfaceArray, final GeographicMapCellType[] geographicMapCellTypeArray, final VelocityProperties velocityProperties, final AllBinaryLayer layer) throws Exception {
        final GeographicMapCellPosition geographicMapCellPosition = this.getRightPosition(geographicMapInterfaceArray, layer);
        if (geographicMapCellPosition !== SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
            final GeographicMapCellPosition possibleStepGeographicMapCellPosition = geographicMapInterfaceArray[0].getGeographicMapCellPositionFactory().getAt(geographicMapCellPosition.getColumn(), geographicMapCellPosition.getRow() - 1);
            this.geographicMapBehavior.getCellTypeAt(geographicMapInterfaceArray, geographicMapCellTypeArray, possibleStepGeographicMapCellPosition);
            final boolean hasSolidBlock = this.hasSolidBlock(geographicMapInterfaceArray, geographicMapCellTypeArray);
            if (hasSolidBlock) {
                if (this.autoStepBlocks) {
                    final TopViewCharacterInterface topViewCharacterInterface = (((TopViewCharacterInterface) layer));
                    topViewCharacterInterface.rightp();
                } else {
                    velocityProperties.getVelocityXBasicDecimalP().setint(0);
                }
            } else {
                final TopViewCharacterInterface topViewCharacterInterface = (((TopViewCharacterInterface) layer));
                topViewCharacterInterface.rightp();
            }
        }
    }

}


