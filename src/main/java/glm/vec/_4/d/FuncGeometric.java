/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glm.vec._4.d;

abstract class FuncGeometric extends ArithmeticOperators {

    public double dot(Vec4d y) {
        return dot((Vec4d) this, y);
    }

    public static double dot(Vec4d x, Vec4d y) {
        double tX = x.x * y.x;
        double tY = x.y * y.y;
        double tZ = x.z * y.z;
        double tW = x.w * y.w;
        return tX + tY + tZ + tW;
    }

    public double length () {
      return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w);
    }

    public static double distance (Vec4d a, Vec4d b) {
      double dx = a.x - b.x;
      double dy = a.y - b.y;
      double dz = a.z - b.z;
      double dw = a.w - b.w;
      return Math.sqrt(dx * dx + dy * dy + dz * dz + dw * dw);
    }

    /**
     * Normalize this vector.
     *
     * @return this
     */
    public Vec4d normalize() {
        return normalize((Vec4d) this);
    }

    /**
     * Normalize this vector and store the result in <code>res</code>.
     *
     * @param res will hold the result
     * @return
     */
    public Vec4d normalize(Vec4d res) {
        double invLength = 1.0 / Math.sqrt(x * x + y * y + z * z + w * w);
        res.x = x * invLength;
        res.y = y * invLength;
        res.z = z * invLength;
        res.w = w * invLength;
        return res;
    }
}
