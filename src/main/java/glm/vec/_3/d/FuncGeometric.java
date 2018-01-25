/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glm.vec._3.d;

abstract class FuncGeometric extends ArithmeticOperators {

    public Vec3d cross(Vec3d y) {
        return cross(y, (Vec3d) this);
    }

    public Vec3d cross_(Vec3d y) {
        return cross(y, new Vec3d());
    }

    public Vec3d cross(Vec3d y, Vec3d res) {
        return cross((Vec3d) this, y, res);
    }

    public static Vec3d cross(Vec3d x, Vec3d y, Vec3d res) {
        return res.set(
                x.y * y.z - y.y * x.z,
                x.z * y.x - y.z * x.x,
                x.x * y.y - y.x * x.y);
    }

    public double length () {
      return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public static double distance (Vec3d a, Vec3d b) {
      double dx = a.x - b.x;
      double dy = a.y - b.y;
      double dz = a.z - b.z;
      return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public double dot(Vec3d y) {
        return dot((Vec3d) this, y);
    }

    public static double dot(Vec3d x, Vec3d y) {
        double tX = x.x * y.x;
        double tY = x.y * y.y;
        double tZ = x.z * y.z;
        return tX + tY + tZ;
    }

    /**
     * Normalize this vector.
     *
     * @return this
     */
    public Vec3d normalize() {
        return normalize((Vec3d) this);
    }

    public Vec3d normalize_() {
        return normalize(new Vec3d());
    }

    /**
     * Normalize this vector and store the result in <code>res</code>.
     *
     * @param res will hold the result
     * @return
     */
    public Vec3d normalize(Vec3d res) {
        double invLength = 1.0 / Math.sqrt(x * x + y * y + z * z);
        res.x = x * invLength;
        res.y = y * invLength;
        res.z = z * invLength;
        return res;
    }
}
