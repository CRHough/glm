/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glm.quatd;

import glm.vec._3.d.Vec3d;

/**
 *
 * @author elect
 */
abstract class funcCommon {

    public static final int SIZE = 4 * Double.BYTES;

    public double w, x, y, z;

    public Quatd add(Quatd y) {
        return add(y, (Quatd) this);
    }

    public Quatd add_(Quatd y) {
        return add(y, new Quatd());
    }

    public Quatd add(Quatd y, Quatd res) {
        return add((Quatd) this, y, res);
    }

    public static Quatd add(Quatd x, Quatd y, Quatd res) {
        res.w = x.w + y.w;
        res.x = x.x + y.x;
        res.y = x.y + y.y;
        res.z = x.z + y.z;
        return res;
    }

    public Quatd mul_(Quatd q) {
        return mul(q, new Quatd());
    }

    public Quatd mul(Quatd q) {
        return mul(q, (Quatd) this);
    }

    public Quatd mul(Quatd q, Quatd res) {
        return Quatd.mul((Quatd) this, q, res);
    }

    public static Quatd mul(Quatd x, Quatd y, Quatd res) {
        return res.set(
                x.w * y.w - x.x * y.x - x.y * y.y - x.z * y.z,
                x.w * y.x + x.x * y.w + x.y * y.z - x.z * y.y,
                x.w * y.y + x.y * y.w + x.z * y.x - x.x * y.z,
                x.w * y.z + x.z * y.w + x.x * y.y - x.y * y.x);
    }

    public Vec3d mul(Vec3d v) {
        return Quatd.mul((Quatd) this, v, v);
    }

    public Vec3d mul_(Vec3d v) {
        return Quatd.mul((Quatd) this, v, new Vec3d());
    }

    public Vec3d mul(Vec3d v, Vec3d res) {
        return Quatd.mul((Quatd) this, v, res);
    }

    public static Vec3d mul(Quatd q, Vec3d v, Vec3d res) {
        double n0 = q.x + q.x;
        double n1 = q.y + q.y;
        double n2 = q.z + q.z;
        double n3 = q.x * n0;
        double n4 = q.y * n1;
        double n5 = q.z * n2;
        double n6 = q.x * n1;
        double n7 = q.x * n2;
        double n8 = q.y * n2;
        double n9 = q.w * n0;
        double n10 = q.w * n1;
        double n11 = q.w * n2;
        res.set((1.0 - (n4 + n5)) * v.x + (n6 - n11) * v.y + (n7 + n10) * v.z,
                (n6 + n11) * v.x + (1.0 - (n3 + n5)) * v.y + (n8 - n9) * v.z,
                (n7 - n10) * v.x + (n8 + n9) * v.y + (1.0 - (n3 + n4)) * v.z);
        return res;
    }

    public Quatd mul(double d) {
        return mul(d, (Quatd) this);
    }

    public Quatd mul_(double d) {
        return mul(d, new Quatd());
    }

    public Quatd mul(float f) {
        return mul(f, (Quatd) this);
    }

    public Quatd mul_(float f) {
        return mul(f, new Quatd());
    }

    public Quatd mul(double f, Quatd res) {
        return Quatd.mul((Quatd) this, f, res);
    }

    public static Quatd mul(Quatd x, double y, Quatd res) {
        return res.set(
                x.w * y,
                x.x * y,
                x.y * y,
                x.z * y);
    }

    public Quatd sub(Quatd y) {
        return sub(y, (Quatd) this);
    }

    public Quatd sub_(Quatd y) {
        return sub(y, new Quatd());
    }

    public Quatd sub(Quatd y, Quatd res) {
        return sub((Quatd) this, y, res);
    }

    public static Quatd sub(Quatd x, Quatd y, Quatd res) {
        res.w = x.w - y.w;
        res.x = x.x - y.x;
        res.y = x.y - y.y;
        res.z = x.z - y.z;
        return res;
    }
}
