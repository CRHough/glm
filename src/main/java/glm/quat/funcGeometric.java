/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glm.quat;

import glm.vec._3.Vec3;

/**
 *
 * @author elect
 */
abstract class funcGeometric extends funcCommon {
    public Quat degreeAxis(float deg, Vec3 v) {
        return Quat.degreeAxis(deg, v, (Quat) this);
    }

    public static Quat degreeAxis_(float deg, Vec3 v) {
        return Quat.degreeAxis(deg, v, new Quat());
    }

    public static Quat degreeAxis(float deg, Vec3 v, Quat res) {

        float a = deg;
        float s = (float) Math.sin(Math.toRadians(a) * 0.5f);

        res.w = (float) Math.cos(Math.toRadians(a) * 0.5f);
        res.x = v.x * s;
        res.y = v.y * s;
        res.z = v.z * s;

        return res;
    }

    public Quat radianAxis(float rad, Vec3 v) {
        return Quat.radianAxis(rad, v, (Quat) this);
    }

    public static Quat radianAxis_(float rad, Vec3 v) {
        return Quat.radianAxis(rad, v, new Quat());
    }

    public static Quat radianAxis(float rad, Vec3 v, Quat res) {
        float s = (float) Math.sin(rad * 0.5f);

        res.w = (float) Math.cos(rad * 0.5f);
        res.x = v.x * s;
        res.y = v.y * s;
        res.z = v.z * s;

        return res;
    }

    public Quat degreeEuler(Vec3 v) {
        return Quat.degreeEuler(v.x, v.y, v.z, (Quat)this);
    }

    public static Quat degreeEuler_(Vec3 v) {
        return Quat.degreeEuler(v.x, v.y, v.z, new Quat());
    }

    public static Quat degreeEuler(float pitch, float yaw, float roll, Quat res) {
      float halfToRad = 0.5f * (float)Math.PI / 180.0f;
      float sx, cx, sy, cy, sz, cz;

      pitch *= halfToRad;
      yaw *= halfToRad;
      roll *= halfToRad;

      sx = (float)Math.sin(pitch);
      cx = (float)Math.cos(pitch);
      sy = (float)Math.sin(yaw);
      cy = (float)Math.cos(yaw);
      sz = (float)Math.sin(roll);
      cz = (float)Math.cos(roll);

      res.x = sx * cy * cz - cx * sy * sz;
      res.y = cx * sy * cz + sx * cy * sz;
      res.z = cx * cy * sz - sx * sy * cz;
      res.w = cx * cy * cz + sx * sy * sz;

      return res;
    }

    public Quat radianEuler(Vec3 v) {
        return Quat.radianEuler(v.x, v.y, v.z, (Quat)this);
    }

    public static Quat radianEuler_(Vec3 v) {
        return Quat.radianEuler(v.x, v.y, v.z, new Quat());
    }

    public static Quat radianEuler(float pitch, float yaw, float roll, Quat res) {
      float sx, cx, sy, cy, sz, cz;

      pitch *= 0.5f;
      yaw *= 0.5f;
      roll *= 0.5f;

      sx = (float)Math.sin(pitch);
      cx = (float)Math.cos(pitch);
      sy = (float)Math.sin(yaw);
      cy = (float)Math.cos(yaw);
      sz = (float)Math.sin(roll);
      cz = (float)Math.cos(roll);

      res.x = sx * cy * cz - cx * sy * sz;
      res.y = cx * sy * cz + sx * cy * sz;
      res.z = cx * cy * sz - sx * sy * cz;
      res.w = cx * cy * cz + sx * sy * sz;

      return res;
    }

    public static Quat lerp (Quat a, Quat b, float t, Quat res) {
      float ax = a.x;
      float ay = a.y;
      float az = a.z;
      float aw = a.w;
      res.x = ax + t * (b.x - ax);
      res.y = ay + t * (b.y - ay);
      res.z = az + t * (b.z - az);
      res.w = aw + t * (b.w - aw);
      return res;
    }

    public static Quat lerp (Quat a, Quat b, float t) {
      return Quat.lerp(a, b, t, new Quat());
    }

    public Quat lerp (Quat b, float t) {
      return Quat.lerp((Quat)this, b, t, (Quat)this);
    }

    public static Quat slerp (Quat a, Quat b, float t, Quat res) {
      // benchmarks:
      //    http://jsperf.com/quaternion-slerp-implementations
      float ax = a.x, ay = a.y, az = a.z, aw = a.w;
      float bx = b.x, by = b.y, bz = b.z, bw = b.w;
      float omega, cosom, sinom, scale0, scale1;

      // calc cosine
      cosom = ax * bx + ay * by + az * bz + aw * bw;
      // adjust signs (if necessary)
      if ( cosom < 0.0f ) {
        cosom = -cosom;
        bx = - bx;
        by = - by;
        bz = - bz;
        bw = - bw;
      }
      // calculate coefficients
      if ( (1.0f - cosom) > 0.000001f ) {
        // standard case (slerp)
        omega  = (float)Math.acos(cosom);
        sinom  = (float)Math.sin(omega);
        scale0 = (float)Math.sin((1.0f - t) * omega) / sinom;
        scale1 = (float)Math.sin(t * omega) / sinom;
      } else {
        // "from" and "to" quaternions are very close
        //  ... so we can do a linear interpolation
        scale0 = 1.0f - t;
        scale1 = t;
      }
      // calculate final values
      res.x = scale0 * ax + scale1 * bx;
      res.y = scale0 * ay + scale1 * by;
      res.z = scale0 * az + scale1 * bz;
      res.w = scale0 * aw + scale1 * bw;

      return res;
    }

    public static Quat slerp (Quat a, Quat b, float t) {
      return Quat.slerp(a, b, t, new Quat());
    }

    public Quat slerp (Quat b, float t) {
      return Quat.slerp((Quat)this, b, t, (Quat)this);
    }

    public float dot(Quat q) {
        return w * q.w + x * q.x + y * q.y + z * q.z;
    }

    public static float dot(Quat q1, Quat q2) {
        return q1.x * q2.x + q1.y * q2.y + q1.z * q2.z + q1.w * q2.w;
    }

    public float length() {
        return length((Quat) this);
    }

    public static float length(Quat q) {
        return (float) Math.sqrt(dot(q, q));
    }

    public Quat normalize() {
        return Quat.normalize((Quat) this, (Quat) this);
    }

    public Quat normalize_() {
        return Quat.normalize((Quat) this, new Quat());
    }

    public Quat normalize(Quat res) {
        return Quat.normalize((Quat) this, res);
    }

    public static Quat normalize(Quat q, Quat res) {
        float len = length(q);
        if (len <= 0) { // Problem
            return new Quat(1, 0, 0, 0);
        }
        float oneOverLen = 1 / len;
        return res.set(q.w * oneOverLen, q.x * oneOverLen, q.y * oneOverLen, q.z * oneOverLen);
    }
}
