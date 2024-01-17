package com.simibubi.create.foundation.render;

import static com.simibubi.create.Create.asResource;

import org.lwjgl.system.MemoryUtil;

import com.jozufozu.flywheel.api.instance.InstanceType;
import com.jozufozu.flywheel.api.layout.FloatRepr;
import com.jozufozu.flywheel.api.layout.IntegerRepr;
import com.jozufozu.flywheel.api.layout.LayoutBuilder;
import com.jozufozu.flywheel.lib.instance.SimpleInstanceType;
import com.simibubi.create.content.contraptions.actors.flwdata.ActorInstance;
import com.simibubi.create.content.kinetics.base.RotatingInstance;
import com.simibubi.create.content.kinetics.belt.BeltInstance;
import com.simibubi.create.content.logistics.flwdata.FlapData;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AllInstanceTypes {
	// FIXME: optimize layouts/pack fields together if possible

	public static final InstanceType<RotatingInstance> ROTATING = SimpleInstanceType.builder(RotatingInstance::new)
			.cullShader(asResource("instance/cull/rotating.glsl"))
			.vertexShader(asResource("instance/rotating.vert"))
			.layout(LayoutBuilder.create()
					.vector("light", IntegerRepr.SHORT, 2)
					.vector("color", FloatRepr.NORMALIZED_UNSIGNED_BYTE, 4)
					.vector("pos", FloatRepr.FLOAT, 3)
					.scalar("speed", FloatRepr.FLOAT)
					.scalar("offset", FloatRepr.FLOAT)
					.vector("axis", FloatRepr.NORMALIZED_BYTE, 3)
					.build())
			.writer((ptr, instance) -> {
				MemoryUtil.memPutShort(ptr, instance.blockLight);
				MemoryUtil.memPutShort(ptr + 2, instance.skyLight);
				MemoryUtil.memPutByte(ptr + 4, instance.r);
				MemoryUtil.memPutByte(ptr + 5, instance.g);
				MemoryUtil.memPutByte(ptr + 6, instance.b);
				MemoryUtil.memPutByte(ptr + 7, instance.a);
				MemoryUtil.memPutFloat(ptr + 8, instance.x);
				MemoryUtil.memPutFloat(ptr + 12, instance.y);
				MemoryUtil.memPutFloat(ptr + 16, instance.z);
				MemoryUtil.memPutFloat(ptr + 20, instance.rotationalSpeed);
				MemoryUtil.memPutFloat(ptr + 24, instance.rotationOffset);
				MemoryUtil.memPutByte(ptr + 28, instance.rotationAxisX);
				MemoryUtil.memPutByte(ptr + 29, instance.rotationAxisY);
				MemoryUtil.memPutByte(ptr + 30, instance.rotationAxisZ);
			})
			.register();
	public static final InstanceType<BeltInstance> BELTS = SimpleInstanceType.builder(BeltInstance::new)
			.cullShader(asResource("instance/cull/belt.glsl"))
			.vertexShader(asResource("instance/belt.vert"))
			.layout(LayoutBuilder.create()
					.vector("light", IntegerRepr.SHORT, 2)
					.vector("color", FloatRepr.NORMALIZED_UNSIGNED_BYTE, 4)
					.vector("pos", FloatRepr.FLOAT, 3)
					.scalar("speed", FloatRepr.FLOAT)
					.scalar("offset", FloatRepr.FLOAT)
					.vector("rotation", FloatRepr.FLOAT, 4)
					.vector("sourceTexture", FloatRepr.FLOAT, 2)
					.vector("scrollTexture", FloatRepr.FLOAT, 4)
					.scalar("scrollMult", FloatRepr.NORMALIZED_BYTE)
					.build())
			.writer((ptr, instance) -> {
				MemoryUtil.memPutShort(ptr, instance.blockLight);
				MemoryUtil.memPutShort(ptr + 2, instance.skyLight);
				MemoryUtil.memPutByte(ptr + 4, instance.r);
				MemoryUtil.memPutByte(ptr + 5, instance.g);
				MemoryUtil.memPutByte(ptr + 6, instance.b);
				MemoryUtil.memPutByte(ptr + 7, instance.a);
				MemoryUtil.memPutFloat(ptr + 8, instance.x);
				MemoryUtil.memPutFloat(ptr + 12, instance.y);
				MemoryUtil.memPutFloat(ptr + 16, instance.z);
				MemoryUtil.memPutFloat(ptr + 20, instance.rotationalSpeed);
				MemoryUtil.memPutFloat(ptr + 24, instance.rotationOffset);
				MemoryUtil.memPutFloat(ptr + 28, instance.qX);
				MemoryUtil.memPutFloat(ptr + 32, instance.qY);
				MemoryUtil.memPutFloat(ptr + 36, instance.qZ);
				MemoryUtil.memPutFloat(ptr + 40, instance.qW);
				MemoryUtil.memPutFloat(ptr + 44, instance.sourceU);
				MemoryUtil.memPutFloat(ptr + 48, instance.sourceV);
				MemoryUtil.memPutFloat(ptr + 52, instance.minU);
				MemoryUtil.memPutFloat(ptr + 56, instance.minV);
				MemoryUtil.memPutFloat(ptr + 60, instance.maxU);
				MemoryUtil.memPutFloat(ptr + 64, instance.maxV);
				MemoryUtil.memPutByte(ptr + 68, instance.scrollMult);
			})
			.register();
	public static final InstanceType<ActorInstance> ACTORS = SimpleInstanceType.builder(ActorInstance::new)
			.cullShader(asResource("instance/cull/contraption_actor.glsl"))
			.vertexShader(asResource("instance/contraption_actor.vert"))
			.layout(LayoutBuilder.create()
					.vector("pos", FloatRepr.FLOAT, 3)
					.vector("light", IntegerRepr.SHORT, 2)
					.scalar("offset", FloatRepr.FLOAT)
					.vector("axis", FloatRepr.NORMALIZED_BYTE, 3)
					.vector("rotation", FloatRepr.FLOAT, 4)
					.vector("rotationCenter", FloatRepr.NORMALIZED_BYTE, 3)
					.scalar("speed", FloatRepr.FLOAT)
					.build())
			.writer((ptr, instance) -> {
				MemoryUtil.memPutFloat(ptr, instance.x);
				MemoryUtil.memPutFloat(ptr + 4, instance.y);
				MemoryUtil.memPutFloat(ptr + 8, instance.z);
				MemoryUtil.memPutShort(ptr + 12, instance.blockLight);
				MemoryUtil.memPutShort(ptr + 14, instance.skyLight);
				MemoryUtil.memPutFloat(ptr + 16, instance.rotationOffset);
				MemoryUtil.memPutByte(ptr + 20, instance.rotationAxisX);
				MemoryUtil.memPutByte(ptr + 21, instance.rotationAxisY);
				MemoryUtil.memPutByte(ptr + 22, instance.rotationAxisZ);
				MemoryUtil.memPutFloat(ptr + 24, instance.qX);
				MemoryUtil.memPutFloat(ptr + 28, instance.qY);
				MemoryUtil.memPutFloat(ptr + 32, instance.qZ);
				MemoryUtil.memPutFloat(ptr + 34, instance.qW);
				MemoryUtil.memPutByte(ptr + 38, instance.rotationCenterX);
				MemoryUtil.memPutByte(ptr + 39, instance.rotationCenterY);
				MemoryUtil.memPutByte(ptr + 40, instance.rotationCenterZ);
				MemoryUtil.memPutFloat(ptr + 42, instance.speed);
			})
			.register();
	public static final InstanceType<FlapData> FLAPS = SimpleInstanceType.builder(FlapData::new)
			.cullShader(asResource("instance/cull/flap.glsl"))
			.vertexShader(asResource("instance/flap.vert"))
			.layout(LayoutBuilder.create()
					.vector("instancePos", FloatRepr.FLOAT, 3)
					.vector("light", IntegerRepr.SHORT, 2)
					.vector("segmentOffset", FloatRepr.FLOAT, 3)
					.vector("pivot", FloatRepr.FLOAT, 3)
					.scalar("horizontalAngle", FloatRepr.FLOAT)
					.scalar("intensity", FloatRepr.FLOAT)
					.scalar("flapScale", FloatRepr.FLOAT)
					.scalar("flapness", FloatRepr.FLOAT)
					.build())
			.writer((ptr, instance) -> {
				MemoryUtil.memPutFloat(ptr, instance.x);
				MemoryUtil.memPutFloat(ptr + 4, instance.y);
				MemoryUtil.memPutFloat(ptr + 8, instance.z);
				MemoryUtil.memPutShort(ptr + 12, instance.blockLight);
				MemoryUtil.memPutShort(ptr + 14, instance.skyLight);
				MemoryUtil.memPutFloat(ptr + 16, instance.segmentOffsetX);
				MemoryUtil.memPutFloat(ptr + 20, instance.segmentOffsetY);
				MemoryUtil.memPutFloat(ptr + 24, instance.segmentOffsetZ);
				MemoryUtil.memPutFloat(ptr + 28, instance.pivotX);
				MemoryUtil.memPutFloat(ptr + 32, instance.pivotY);
				MemoryUtil.memPutFloat(ptr + 36, instance.pivotZ);
				MemoryUtil.memPutFloat(ptr + 40, instance.horizontalAngle);
				MemoryUtil.memPutFloat(ptr + 44, instance.intensity);
				MemoryUtil.memPutFloat(ptr + 48, instance.flapScale);
				MemoryUtil.memPutFloat(ptr + 52, instance.flapness);
			})
			.register();

	public static void init() {
		// noop
	}
}
