package com.arvin;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *  背景音乐类
 */

public class Music {

    // 空参构造
    public Music() throws FileNotFoundException, JavaLayerException {
        Player player;  // 播放音乐
        String str = System.getProperty("user.dir") + "/src/Music/music.wav";
        BufferedInputStream name = new BufferedInputStream(new FileInputStream(str)); // 读取 str 中音乐 将异常添加到方法签名
        player = new Player(name); // 实例化 Player 对象 将异常添加到方法签名
        player.play(); // 调用 Player 的 play() 开始播放音乐
    }

}
