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
abstract class funcGeometric extends funcCommon {
    public Quatd degreeAxis(double deg, Vec3d v) {
        return Quatd.degreeAxis(deg, v, (Quatd) this);
    }

    public static Quatd degreeAxis_(double deg, Vec3d v) {
        return Quatd.degreeAxis(deg, v, new Quatd());
    }

    public static Quatd degreeAxis(double deg, Vec3d v, Quatd res) {
      return Quatd.radianAxis(Math.toRadians(deg), v, res);
    }

    public Quatd radianAxis(double rad, Vec3d v) {
        return Quatd.radianAxis(rad, v, (Quatd) this);
    }

    public static Quatd radianAxis_(double rad, Vec3d v) {
        return Quatd.radianAxis(rad, v, new Quatd());
    }

    public static Quatd radianAxis(double rad, Vec3d v, Quatd res) {
        double s = Math.sin(rad * 0.5f);

        res.w = Math.cos(rad * 0.5f);
        res.x = v.x * s;
        res.y = v.y * s;
        res.z = v.z * s;

        return res;
    }

    public double dot(Quatd q) {
        return w * q.w + x * q.x + y * q.y + z * q.z;
    }

    public static double dot(Quatd q1, Quatd q2) {
        return q1.x * q2.x + q1.y * q2.y + q1.z * q2.z + q1.w * q2.w;
    }

    public double length() {
        return length((Quatd) this);
    }

    public static double length(Quatd q) {
        return Math.sqrt(dot(q, q));
    }

    public Quatd normalize() {
        return Quatd.normalize((Quatd) this, (Quatd) this);
    }

    public Quatd normalize_() {
        return Quatd.normalize((Quatd) this, new Quatd());
    }

    public Quatd normalize(Quatd res) {
        return Quatd.normalize((Quatd) this, res);
    }

    public static Quatd normalize(Quatd q, Quatd res) {
        double len = length(q);
        if (len <= 0) { // Problem
            return new Quatd(1, 0, 0, 0);
        }
        double oneOverLen = 1 / len;
        return res.set(q.w * oneOverLen, q.x * oneOverLen, q.y * oneOverLen, q.z * oneOverLen);
    }
}
