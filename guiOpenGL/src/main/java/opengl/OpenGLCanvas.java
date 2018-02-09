package opengl;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class OpenGLCanvas extends GLCanvas implements GLEventListener {
//http://www.land-of-kain.de/docs/jogl/

    private int fps;
    private FPSAnimator animator;
    private GLU glu;
    private Texture earthTexture;

    public OpenGLCanvas(int width, int height, GLCapabilities glCapabilities) {

        super(glCapabilities);
        setSize(width, height);
        fps = 60;
        this.addGLEventListener(this);
    }

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {

        GL2 gl = glAutoDrawable.getGL().getGL2();
//        glAutoDrawable.setGL(new DebugGL(gl));

        // Global settings
        // Enable z- (depth) buffer for hidden surface removal.
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glDepthFunc(GL.GL_LEQUAL);
        // Enable smooth shading.
        gl.glShadeModel(GL2.GL_SMOOTH);
        // Define "clear" color.
        gl.glClearColor(0f, 0f, 0f, 0f);
        // We want a nice perspective.
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);

        // Start animator (which should be a field).
        animator = new FPSAnimator(this, fps);
        animator.start();

        glu = new GLU();
        createEarthTexture(gl.getGLProfile());
    }

    private void createEarthTexture(GLProfile glProfile) {
        try {
            InputStream stream = getClass().getResourceAsStream("texture/Earth.png");
            InputStream stream2 = new FileInputStream("D:\\DevGame\\PointyAndClicky\\guiOpenGL\\src\\main\\resources\\texture\\Earth.png");
            TextureData data = TextureIO.newTextureData(glProfile, stream2, false, "png");
            earthTexture = TextureIO.newTexture(data);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {

        if (!animator.isAnimating()) {
            System.out.println("animator running");
            return;
        }
        final GL2 gl = glAutoDrawable.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

//        this.setCamera(gl, 30);
        this.setCamera(gl, 100);
        this.setLight(gl);
        this.drawSphere(gl);
//        this.drawTriangle(gl);

        this.drawLine(gl, 0, 0, 100, 100, 1, 0, 0);
        this.drawLine(gl, 0, 0, 100, -100, 0, 1, 0);
        this.drawLine(gl, 0, 0, -100, -100, 0, 0, 1);
        this.drawLine(gl, 0, 0, -100, 100, 1, 1, 0);

        this.drawLine(gl, -10, -10, 50, 40, 1, 1, 1);
        this.drawLine(gl, 0, 0, 50, 40, 1, 1, 1);
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int x, int y, int width, int height) {

        GL gl = glAutoDrawable.getGL();
        gl.glViewport(0, 0, width, height);
    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    private void drawLine(GL2 gl, int startX, int startY, int endX, int endY, float r, float g, float b) {

        gl.glColor3f(r, g, b);
        gl.glLineWidth(5);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2i(startX, startY);
        gl.glVertex2i(endX, endY);
        gl.glEnd();
    }

    private void drawTriangle(GL2 gl) {

        gl.glColor3f(0.9f, 0.5f, 0.2f);
        gl.glBegin(GL.GL_TRIANGLE_FAN);
        gl.glVertex3f(-20, -20, 0);
        gl.glVertex3f(+20, -20, 0);
        gl.glVertex3f(0, 20, 0);
        gl.glEnd();
    }

    private void drawSphere(GL2 gl) {

        // Set material properties.
        float[] rgba = {1f, 1f, 1f};
        gl.glMaterialfv(GL.GL_FRONT, GL2.GL_AMBIENT, rgba, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL2.GL_SPECULAR, rgba, 0);
        gl.glMaterialf(GL.GL_FRONT, GL2.GL_SHININESS, 0.5f);

        // Apply texture.
//        earthTexture.enable(gl);
//        earthTexture.bind(gl);

        // Draw sphere
        gl.glColor3f(0.3f, 0.5f, 1f);
        GLUquadric earth = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(earth, GLU.GLU_FILL); // possible draw styles: FILL, LINE, POINT
        glu.gluQuadricNormals(earth, GLU.GLU_FLAT);
        glu.gluQuadricOrientation(earth, GLU.GLU_OUTSIDE);
        final float radius = 6.378f;
        final int slices = 16;
        final int stacks = 16;
        glu.gluSphere(earth, radius, slices, stacks);
        glu.gluDeleteQuadric(earth);
    }


    private void setCamera(GL2 gl, float distance) {

        // Change to projection matrix.
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        // Perspective.
        float widthHeightRatio = (float) getWidth() / (float) getHeight();
        glu.gluPerspective(45, widthHeightRatio, 1, 1000);
        glu.gluLookAt(0, 0, distance, 0, 0, 0, 0, 1, 0);

        // Change back to model view matrix.
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    private void setLight(GL2 gl) {

        // Prepare light parameters.
        float SHINE_ALL_DIRECTIONS = 1;
        float[] lightPos = {-30, 0, 0, SHINE_ALL_DIRECTIONS};
        float[] lightColorAmbient = {0.2f, 0.2f, 0.2f, 1f};
        float[] lightColorSpecular = {0.8f, 0.8f, 0.8f, 1f};
        // Set light parameters.
        gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_POSITION, lightPos, 0);
        gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_AMBIENT, lightColorAmbient, 0);
        gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_SPECULAR, lightColorSpecular, 0);
        // Enable lighting in GL.
        gl.glEnable(GL2.GL_LIGHT1);
        gl.glEnable(GL2.GL_LIGHTING);
    }
}
