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
abstract class FuncGeometric extends BooleanOperators {

    public Vec2d cross(Vec2d y) {
        return cross(y, (Vec2d) this);
    }

    public Vec2d cross_(Vec2d y) {
        return cross(y, new Vec2d());
    }

    public Vec2d cross(Vec2d y, Vec2d result) {
        return cross((Vec2d) this, y, result);
    }

    public static Vec2d cross(Vec2d x, Vec2d y, Vec2d result) {
        result.y = x.x * y.y - y.x * x.y;
        result.x = 0f;
        return result;
    }

    public double distance(Vec2d p0, Vec2d p1) {
        double t0x = p0.x - p1.x;
        double t0y = p0.y - p1.y;
        double dot = t0x * t0y + t0x * t0y;
        return Math.sqrt(dot);
    }

    public double dot(Vec2d y) {
        return dot((Vec2d) this, y);
    }

    public static double dot(Vec2d x, Vec2d y) {
        double tX = x.x * y.x;
        double tY = x.y * y.y;
        return tX + tY;
    }

    public static double length(Vec2d x, Vec2d result) {
        return Math.sqrt(dot(x, x));
    }
}
