/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glm.vec._4.d;

/**
 *
 * @author elect
 */
public class Vec4d extends FuncRelational {
  public Vec4d() {
      this(0);
  }

  public Vec4d(Vec4d v) {
      this(v.x, v.y, v.z, v.w);
  }

  public Vec4d(float[] fa) {
      this(fa, 0);
  }

  public Vec4d(float[] fa, int i) {
      this(fa[i + 0], fa[i + 1], fa[i + 2], fa[i + 3]);
  }

  public Vec4d(double d) {
    this.x = d;
    this.y = d;
    this.z = d;
    this.w = d;
  }

  public Vec4d(double[] da) {
      this(da, 0);
  }

  public Vec4d(double[] da, int i) {
      this(da[i + 0], da[i + 1], da[i + 2], da[i + 3]);
  }

  public Vec4d(double x, double y, double z, double w) {
    this.x = x;
    this.y = y;
    this.z = z;
    this.w = w;
  }

  public Vec4d set(Vec4d v) {
      return set(v.x, v.y, v.z, v.w);
  }

  public Vec4d set(float f) {
      return set(f, f, f, f);
  }

  public Vec4d set(float[] fa) {
      return set(fa, 0);
  }

  public Vec4d set(float[] fa, int i) {
      return set(fa[i + 0], fa[i + 1], fa[i + 2], fa[i + 3]);
  }

  public Vec4d set(double d) {
      this.x = d;
      this.y = d;
      this.z = d;
      this.w = d;
      return this;
  }

  public Vec4d set(double[] da) {
      return set(da, 0);
  }

  public Vec4d set(double[] da, int i) {
      return set(da[i + 0], da[i + 1], da[i + 2], da[i + 3]);
  }

  public Vec4d set(double x, double y, double z, double w) {
    this.x = x;
    this.y = y;
    this.z = z;
    this.w = w;
    return this;
  }

  public Vec4d set(float x, float y, float z, float w) {
    return set(x, y, z, w);
  }

  public float[] toFA_() {
      return toFA(new float[4]);
  }

  public float[] toFA(float[] fa) {
      fa[0] = (float)x;
      fa[1] = (float)y;
      fa[2] = (float)z;
      fa[3] = (float)w;
      return fa;
  }

  public double[] toDA_() {
      return toDA(new double[4]);
  }

  public double[] toDA(double[] fa) {
      fa[0] = x;
      fa[1] = y;
      fa[2] = z;
      fa[3] = w;
      return fa;
  }
}
