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
        double s = Math.sin(rad * 0.5);

        res.w = Math.cos(rad * 0.5);
        res.x = v.x * s;
        res.y = v.y * s;
        res.z = v.z * s;

        return res;
    }

    public Quatd degreeEuler(Vec3d v) {
        return Quatd.degreeEuler(v.x, v.y, v.z, (Quatd)this);
    }

    public static Quatd degreeEuler_(Vec3d v) {
        return Quatd.degreeEuler(v.x, v.y, v.z, new Quatd());
    }

    public static Quatd degreeEuler(double pitch, double yaw, double roll, Quatd res) {
      double halfToRad = 0.5 * Math.PI / 180.0;
      double sx, cx, sy, cy, sz, cz;

      pitch *= halfToRad;
      yaw *= halfToRad;
      roll *= halfToRad;

      sx = Math.sin(pitch);
      cx = Math.cos(pitch);
      sy = Math.sin(yaw);
      cy = Math.cos(yaw);
      sz = Math.sin(roll);
      cz = Math.cos(roll);

      res.x = sx * cy * cz - cx * sy * sz;
      res.y = cx * sy * cz + sx * cy * sz;
      res.z = cx * cy * sz - sx * sy * cz;
      res.w = cx * cy * cz + sx * sy * sz;

      return res;
    }

    public Quatd radianEuler(Vec3d v) {
        return Quatd.radianEuler(v.x, v.y, v.z, (Quatd)this);
    }

    public static Quatd radianEuler_(Vec3d v) {
        return Quatd.radianEuler(v.x, v.y, v.z, new Quatd());
    }

    public static Quatd radianEuler(double pitch, double yaw, double roll, Quatd res) {
      double sx, cx, sy, cy, sz, cz;

      pitch *= 0.5;
      yaw *= 0.5;
      roll *= 0.5;

      sx = Math.sin(pitch);
      cx = Math.cos(pitch);
      sy = Math.sin(yaw);
      cy = Math.cos(yaw);
      sz = Math.sin(roll);
      cz = Math.cos(roll);

      res.x = sx * cy * cz - cx * sy * sz;
      res.y = cx * sy * cz + sx * cy * sz;
      res.z = cx * cy * sz - sx * sy * cz;
      res.w = cx * cy * cz + sx * sy * sz;

      return res;
    }

    public static Quatd lerp (Quatd a, Quatd b, double t, Quatd res) {
      double ax = a.x;
      double ay = a.y;
      double az = a.z;
      double aw = a.w;
      res.x = ax + t * (b.x - ax);
      res.y = ay + t * (b.y - ay);
      res.z = az + t * (b.z - az);
      res.w = aw + t * (b.w - aw);
      return res;
    }

    public static Quatd lerp (Quatd a, Quatd b, double t) {
      return Quatd.lerp(a, b, t, new Quatd());
    }

    public Quatd lerp (Quatd b, double t) {
      return Quatd.lerp((Quatd)this, b, t, (Quatd)this);
    }

    public static Quatd slerp (Quatd a, Quatd b, double t, Quatd res) {
      // benchmarks:
      //    http://jsperf.com/quaternion-slerp-implementations
      double ax = a.x, ay = a.y, az = a.z, aw = a.w;
      double bx = b.x, by = b.y, bz = b.z, bw = b.w;
      double omega, cosom, sinom, scale0, scale1;

      // calc cosine
      cosom = ax * bx + ay * by + az * bz + aw * bw;
      // adjust signs (if necessary)
      if ( cosom < 0.0 ) {
        cosom = -cosom;
        bx = - bx;
        by = - by;
        bz = - bz;
        bw = - bw;
      }
      // calculate coefficients
      if ( (1.0 - cosom) > 0.000001 ) {
        // standard case (slerp)
        omega  = Math.acos(cosom);
        sinom  = Math.sin(omega);
        scale0 = Math.sin((1.0 - t) * omega) / sinom;
        scale1 = Math.sin(t * omega) / sinom;
      } else {
        // "from" and "to" quaternions are very close
        //  ... so we can do a linear interpolation
        scale0 = 1.0 - t;
        scale1 = t;
      }
      // calculate final values
      res.x = scale0 * ax + scale1 * bx;
      res.y = scale0 * ay + scale1 * by;
      res.z = scale0 * az + scale1 * bz;
      res.w = scale0 * aw + scale1 * bw;

      return res;
    }

    public static Quatd slerp (Quatd a, Quatd b, double t) {
      return Quatd.slerp(a, b, t, new Quatd());
    }

    public Quatd slerp (Quatd b, double t) {
      return Quatd.slerp((Quatd)this, b, t, (Quatd)this);
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
