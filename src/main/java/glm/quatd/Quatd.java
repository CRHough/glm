/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glm.quatd;

import glm.mat._4.d.Mat4d;
import glm.vec._3.d.Vec3d;

/**
 *
 * @author GBarbieri
 */
public class Quatd extends funcGeometric {
    public Quatd() {
        this(0, 0, 0);
    }

    public Quatd(double x, double y, double z) {
        this(1, x, y, z);
    }

    public Quatd(Quatd q) {
        this(q.w, q.x, q.y, q.z);
    }

    public Quatd(double f, Vec3d v) {
        this(f, v.x, v.y, v.z);
    }

    public Quatd(double w, double x, double y, double z) {
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Quatd set() {
        return set(0, 0, 0);
    }

    public Quatd set(double x, double y, double z) {
        return set(1, x, y, z);
    }

    public Quatd set(Quatd q) {
        return set(q.w, q.x, q.y, q.z);
    }

    public Quatd set(double f, Vec3d v) {
        return set(f, v.x, v.y, v.z);
    }

    public Quatd set(double w, double x, double y, double z) {
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public Quatd identity () {
      this.w = 1;
      this.x = 0;
      this.y = 0;
      this.z = 0;
      return this;
    }

    public Quatd conjugate_() {
        return conjugate(new Quatd());
    }

    public Quatd conjugate() {
        return conjugate(this);
    }

    public Quatd conjugate(Quatd res) {
        return res.set(w, -x, -y, -z);
    }

    public static Quatd cast_(Mat4d m) {
        return cast(m, new Quatd());
    }

    public static Quatd cast(Mat4d m, Quatd res) {
        double fourXSquaredMinus1 = m.m00 - m.m11 - m.m22;
        double fourYSquaredMinus1 = m.m11 - m.m00 - m.m22;
        double fourZSquaredMinus1 = m.m22 - m.m00 - m.m11;
        double fourWSquaredMinus1 = m.m00 + m.m11 + m.m22;

        int biggestIndex = 0;
        double fourBiggestSquaredMinus1 = fourWSquaredMinus1;
        if (fourXSquaredMinus1 > fourBiggestSquaredMinus1) {
            fourBiggestSquaredMinus1 = fourXSquaredMinus1;
            biggestIndex = 1;
        }
        if (fourYSquaredMinus1 > fourBiggestSquaredMinus1) {
            fourBiggestSquaredMinus1 = fourYSquaredMinus1;
            biggestIndex = 2;
        }
        if (fourZSquaredMinus1 > fourBiggestSquaredMinus1) {
            fourBiggestSquaredMinus1 = fourZSquaredMinus1;
            biggestIndex = 3;
        }

        double biggestVal = (Math.sqrt(fourBiggestSquaredMinus1 + 1) * 0.5);
        double mult = 0.25 / biggestVal;

        switch (biggestIndex) {
            case 0:
                res.w = biggestVal;
                res.x = (m.m12 - m.m21) * mult;
                res.y = (m.m20 - m.m02) * mult;
                res.z = (m.m01 - m.m10) * mult;
                break;
            case 1:
                res.w = (m.m12 - m.m21) * mult;
                res.x = biggestVal;
                res.y = (m.m01 + m.m10) * mult;
                res.z = (m.m20 + m.m02) * mult;
                break;
            case 2:
                res.w = (m.m20 - m.m02) * mult;
                res.x = (m.m01 + m.m10) * mult;
                res.y = biggestVal;
                res.z = (m.m12 + m.m21) * mult;
                break;
            case 3:
                res.w = (m.m01 - m.m10) * mult;
                res.x = (m.m20 + m.m02) * mult;
                res.y = (m.m12 + m.m21) * mult;
                res.z = biggestVal;
                break;
        }
        return res;
    }

    public Mat4d toMat_() {
        return toMat(new Mat4d());
    }

    public Mat4d toMat(Mat4d res) {
        double dx = x + x, dy = y + y, dz = z + z;
        double q00 = dx * x, q11 = dy * y, q22 = dz * z;
        double q01 = dx * y, q02 = dx * z, q03 = dx * w;
        double q12 = dy * z, q13 = dy * w, q23 = dz * w;
        res.m00 = 1.0 - q11 - q22;
        res.m01 = q01 + q23;
        res.m02 = q02 - q13;
        res.m03 = 0.0;
        res.m10 = q01 - q23;
        res.m11 = 1.0 - q22 - q00;
        res.m12 = q12 + q03;
        res.m13 = 0.0;
        res.m20 = q02 + q13;
        res.m21 = q12 - q03;
        res.m22 = 1.0 - q11 - q00;
        res.m23 = 0.0;
        res.m30 = 0.0;
        res.m31 = 0.0;
        res.m32 = 0.0;
        res.m33 = 1.0;
        return res;
    }
}
