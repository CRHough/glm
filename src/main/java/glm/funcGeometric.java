/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glm;

import glm.quat.Quat;
import glm.quatd.Quatd;
import glm.vec._3.Vec3;
import glm.vec._3.d.Vec3d;
import glm.vec._4.Vec4;

/**
 *
 * @author GBarbieri
 */
abstract class funcGeometric extends funcExponential {
    public static Quat degreeAxis_(float degAngle, Vec3 v) {
        return Quat.degreeAxis_(degAngle, v);
    }

    public static Quat degreeAxis(float degAngle, Vec3 v, Quat res) {
        return Quat.degreeAxis(degAngle, v, res);
    }

    public static Quat radianAxis_(float radAngle, Vec3 v) {
        return Quat.radianAxis_(radAngle, v);
    }

    public static Quat radianAxis(float radAngle, Vec3 v, Quat res) {
        return Quat.radianAxis(radAngle, v, res);
    }

    public static Quatd degreeAxis_(double degAngle, Vec3d v) {
        return Quatd.degreeAxis_(degAngle, v);
    }

    public static Quatd degreeAxis(double degAngle, Vec3d v, Quatd res) {
        return Quatd.degreeAxis(degAngle, v, res);
    }

    public static Quatd radianAxis_(double radAngle, Vec3d v) {
        return Quatd.radianAxis_(radAngle, v);
    }

    public static Quatd radianAxis(double radAngle, Vec3d v, Quatd res) {
        return Quatd.radianAxis(radAngle, v, res);
    }

    public static float length(float x) {
        return (float)Math.abs(x);
    }

    public static float dot(Vec4 v0, Vec4 v1) {
        return Vec4.dot(v0, v1);
    }

    public static float dot(Quat v0, Quat v1) {
        return Quat.dot(v0, v1);
    }

    public static Vec3 cross(Vec3 v0, Vec3 v1) {
        return v0.cross(v1);
    }

    public static Vec3 cross_(Vec3 v0, Vec3 v1) {
        return v0.cross_(v1);
    }
}
