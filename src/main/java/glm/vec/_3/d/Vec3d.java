/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glm.vec._3.d;

/**
 *
 * @author GBarbieri
 */
public class Vec3d extends FuncRelational {
  public Vec3d() {
      this(0);
  }

  public Vec3d(Vec3d v) {
      this(v.x, v.y, v.z);
  }

  public Vec3d(float[] fa) {
      this(fa, 0);
  }

  public Vec3d(float[] fa, int i) {
      this(fa[i + 0], fa[i + 1], fa[i + 2]);
  }

  public Vec3d(double d) {
    this.x = d;
    this.y = d;
    this.z = d;
  }

  public Vec3d(double[] da) {
      this(da, 0);
  }

  public Vec3d(double[] da, int i) {
      this(da[i + 0], da[i + 1], da[i + 2]);
  }

  public Vec3d(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public Vec3d set(Vec3d v) {
      return set(v.x, v.y, v.z);
  }

  public Vec3d set(float f) {
      return set(f, f, f);
  }

  public Vec3d set(float[] fa) {
      return set(fa, 0);
  }

  public Vec3d set(float[] fa, int i) {
      return set(fa[i + 0], fa[i + 1], fa[i + 2]);
  }

  public Vec3d set(double d) {
      this.x = d;
      this.y = d;
      this.z = d;
      return this;
  }

  public Vec3d set(double[] da) {
      return set(da, 0);
  }

  public Vec3d set(double[] da, int i) {
      return set(da[i + 0], da[i + 1], da[i + 2]);
  }

  public Vec3d set(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
    return this;
  }

  public Vec3d set(float x, float y, float z) {
    return set(x, y, z);
  }

  public float[] toFA_() {
      return toFA(new float[3]);
  }

  public float[] toFA(float[] fa) {
      fa[0] = (float)x;
      fa[1] = (float)y;
      fa[2] = (float)z;
      return fa;
  }

  public double[] toDA_() {
      return toDA(new double[3]);
  }

  public double[] toDA(double[] fa) {
      fa[0] = x;
      fa[1] = y;
      fa[2] = z;
      return fa;
  }
}
