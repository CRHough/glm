/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glm.vec._2.d;

/**
 *
 * @author elect
 */
public class Vec2d extends FuncRelational {
  public Vec2d() {
      this(0);
  }

  public Vec2d(Vec2d v) {
      this(v.x, v.y);
  }

  public Vec2d(float[] fa) {
      this(fa, 0);
  }

  public Vec2d(float[] fa, int i) {
      this(fa[i + 0], fa[i + 1]);
  }

  public Vec2d(double d) {
    this.x = d;
    this.y = d;
  }

  public Vec2d(double[] da) {
      this(da, 0);
  }

  public Vec2d(double[] da, int i) {
      this(da[i + 0], da[i + 1]);
  }

  public Vec2d(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public Vec2d set(Vec2d v) {
      return set(v.x, v.y);
  }

  public Vec2d set(float f) {
      return set(f, f);
  }

  public Vec2d set(float[] fa) {
      return set(fa, 0);
  }

  public Vec2d set(float[] fa, int i) {
      return set(fa[i + 0], fa[i + 1]);
  }

  public Vec2d set(double d) {
      this.x = d;
      this.y = d;
      return this;
  }

  public Vec2d set(double[] da) {
      return set(da, 0);
  }

  public Vec2d set(double[] da, int i) {
      return set(da[i + 0], da[i + 1]);
  }

  public Vec2d set(double x, double y) {
    this.x = x;
    this.y = y;
    return this;
  }

  public Vec2d set(float x, float y) {
    return set(x, y);
  }

  public float[] toFA_() {
      return toFA(new float[2]);
  }

  public float[] toFA(float[] fa) {
      fa[0] = (float)x;
      fa[1] = (float)y;
      return fa;
  }

  public double[] toDA_() {
      return toDA(new double[2]);
  }

  public double[] toDA(double[] fa) {
      fa[0] = x;
      fa[1] = y;
      return fa;
  }
}
