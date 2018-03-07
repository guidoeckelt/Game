package de.charaktar.opengl;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;

import javax.swing.*;
import java.awt.*;

public class Entry {

    public static void main(String[] args) {

        GLProfile glProfile = GLProfile.getDefault();
        GLCapabilities glCapabilities = new GLCapabilities(glProfile);
        glCapabilities.setRedBits(8);
        glCapabilities.setBlueBits(8);
        glCapabilities.setGreenBits(8);
        glCapabilities.setAlphaBits(8);
        OpenGLCanvas canvas = new OpenGLCanvas(800, 600, glCapabilities);
        JFrame frame = new JFrame("JOGL");
        frame.getContentPane().add(canvas, BorderLayout.CENTER);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        canvas.requestFocus();
    }
}
