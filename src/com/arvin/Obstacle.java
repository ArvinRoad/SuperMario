package com.arvin;

import java.awt.image.BufferedImage;

/**
 *  障碍物类
 */

public class Obstacle implements Runnable{

    // 用于表示当前坐标
    private int x;
    private int y;

    // 用于记录障碍物类型
    private int type;

    // 用于显示图像
    private BufferedImage show = null;

    // 定义当前场景对象
    private BackGround BackGround = null;

    // 定义一个线程对象 用于完成我们旗子下落的过程
    private Thread thread = new Thread(this);

    // 构造函数
    public Obstacle (int x, int y, int type, BackGround BackGround) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.BackGround = BackGround;
        show = StaticValue.Obstacle.get(type);  //  得到该类型的图像

        // 如果是旗子的话 启动线程
        if (type == 4){
            thread.start();
        }
    }

    // 生成上面四个变量的 Get 方法


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getType() {
        return type;
    }

    public BufferedImage getShow() {
        return show;
    }

    // 重写 Runnable 的抽象方法

    @Override
    public void run() {
        while(true){

            if (this.BackGround.isReach()) { // 判断马里奥此时是否到达了旗子的位置
                if (this.y < 374) { // 判断此时的旗子有没有落到地上
                    this.y += 5;
                }else {
                    this.BackGround.setBase(true);
                }
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }

        }
    }
}
