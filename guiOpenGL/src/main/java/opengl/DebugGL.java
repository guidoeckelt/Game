package opengl;

import com.jogamp.opengl.*;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class DebugGL implements GL {
    public DebugGL(GL gl) {
    }

    @Override
    public void glActiveTexture(int i) {

    }

    @Override
    public void glBindBuffer(int i, int i1) {

    }

    @Override
    public void glBindFramebuffer(int i, int i1) {

    }

    @Override
    public void glBindRenderbuffer(int i, int i1) {

    }

    @Override
    public void glBindTexture(int i, int i1) {

    }

    @Override
    public void glBlendEquation(int i) {

    }

    @Override
    public void glBlendEquationSeparate(int i, int i1) {

    }

    @Override
    public void glBlendFunc(int i, int i1) {

    }

    @Override
    public void glBlendFuncSeparate(int i, int i1, int i2, int i3) {

    }

    @Override
    public void glBufferData(int i, long l, Buffer buffer, int i1) {

    }

    @Override
    public void glBufferSubData(int i, long l, long l1, Buffer buffer) {

    }

    @Override
    public int glCheckFramebufferStatus(int i) {
        return 0;
    }

    @Override
    public void glClear(int i) {

    }

    @Override
    public void glClearColor(float v, float v1, float v2, float v3) {

    }

    @Override
    public void glClearDepthf(float v) {

    }

    @Override
    public void glClearStencil(int i) {

    }

    @Override
    public void glColorMask(boolean b, boolean b1, boolean b2, boolean b3) {

    }

    @Override
    public void glCompressedTexImage2D(int i, int i1, int i2, int i3, int i4, int i5, int i6, Buffer buffer) {

    }

    @Override
    public void glCompressedTexImage2D(int i, int i1, int i2, int i3, int i4, int i5, int i6, long l) {

    }

    @Override
    public void glCompressedTexSubImage2D(int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7, Buffer buffer) {

    }

    @Override
    public void glCompressedTexSubImage2D(int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7, long l) {

    }

    @Override
    public void glCopyTexImage2D(int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {

    }

    @Override
    public void glCopyTexSubImage2D(int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {

    }

    @Override
    public void glCullFace(int i) {

    }

    @Override
    public void glDeleteBuffers(int i, IntBuffer intBuffer) {

    }

    @Override
    public void glDeleteBuffers(int i, int[] ints, int i1) {

    }

    @Override
    public void glDeleteFramebuffers(int i, IntBuffer intBuffer) {

    }

    @Override
    public void glDeleteFramebuffers(int i, int[] ints, int i1) {

    }

    @Override
    public void glDeleteRenderbuffers(int i, IntBuffer intBuffer) {

    }

    @Override
    public void glDeleteRenderbuffers(int i, int[] ints, int i1) {

    }

    @Override
    public void glDeleteTextures(int i, IntBuffer intBuffer) {

    }

    @Override
    public void glDeleteTextures(int i, int[] ints, int i1) {

    }

    @Override
    public void glDepthFunc(int i) {

    }

    @Override
    public void glDepthMask(boolean b) {

    }

    @Override
    public void glDepthRangef(float v, float v1) {

    }

    @Override
    public void glDisable(int i) {

    }

    @Override
    public void glDrawArrays(int i, int i1, int i2) {

    }

    @Override
    public void glDrawElements(int i, int i1, int i2, long l) {

    }

    @Override
    public void glEnable(int i) {

    }

    @Override
    public void glFinish() {

    }

    @Override
    public void glFlush() {

    }

    @Override
    public void glFlushMappedBufferRange(int i, long l, long l1) {

    }

    @Override
    public void glFramebufferRenderbuffer(int i, int i1, int i2, int i3) {

    }

    @Override
    public void glFramebufferTexture2D(int i, int i1, int i2, int i3, int i4) {

    }

    @Override
    public void glFrontFace(int i) {

    }

    @Override
    public void glGenBuffers(int i, IntBuffer intBuffer) {

    }

    @Override
    public void glGenBuffers(int i, int[] ints, int i1) {

    }

    @Override
    public void glGenFramebuffers(int i, IntBuffer intBuffer) {

    }

    @Override
    public void glGenFramebuffers(int i, int[] ints, int i1) {

    }

    @Override
    public void glGenRenderbuffers(int i, IntBuffer intBuffer) {

    }

    @Override
    public void glGenRenderbuffers(int i, int[] ints, int i1) {

    }

    @Override
    public void glGenTextures(int i, IntBuffer intBuffer) {

    }

    @Override
    public void glGenTextures(int i, int[] ints, int i1) {

    }

    @Override
    public void glGenerateMipmap(int i) {

    }

    @Override
    public void glGetBooleanv(int i, ByteBuffer byteBuffer) {

    }

    @Override
    public void glGetBooleanv(int i, byte[] bytes, int i1) {

    }

    @Override
    public void glGetBufferParameteriv(int i, int i1, IntBuffer intBuffer) {

    }

    @Override
    public void glGetBufferParameteriv(int i, int i1, int[] ints, int i2) {

    }

    @Override
    public int glGetError() {
        return 0;
    }

    @Override
    public void glGetFloatv(int i, FloatBuffer floatBuffer) {

    }

    @Override
    public void glGetFloatv(int i, float[] floats, int i1) {

    }

    @Override
    public void glGetFramebufferAttachmentParameteriv(int i, int i1, int i2, IntBuffer intBuffer) {

    }

    @Override
    public void glGetFramebufferAttachmentParameteriv(int i, int i1, int i2, int[] ints, int i3) {

    }

    @Override
    public int glGetGraphicsResetStatus() {
        return 0;
    }

    @Override
    public void glGetIntegerv(int i, IntBuffer intBuffer) {

    }

    @Override
    public void glGetIntegerv(int i, int[] ints, int i1) {

    }

    @Override
    public void glGetRenderbufferParameteriv(int i, int i1, IntBuffer intBuffer) {

    }

    @Override
    public void glGetRenderbufferParameteriv(int i, int i1, int[] ints, int i2) {

    }

    @Override
    public String glGetString(int i) {
        return null;
    }

    @Override
    public void glGetTexParameterfv(int i, int i1, FloatBuffer floatBuffer) {

    }

    @Override
    public void glGetTexParameterfv(int i, int i1, float[] floats, int i2) {

    }

    @Override
    public void glGetTexParameteriv(int i, int i1, IntBuffer intBuffer) {

    }

    @Override
    public void glGetTexParameteriv(int i, int i1, int[] ints, int i2) {

    }

    @Override
    public void glGetnUniformfv(int i, int i1, int i2, FloatBuffer floatBuffer) {

    }

    @Override
    public void glGetnUniformfv(int i, int i1, int i2, float[] floats, int i3) {

    }

    @Override
    public void glGetnUniformiv(int i, int i1, int i2, IntBuffer intBuffer) {

    }

    @Override
    public void glGetnUniformiv(int i, int i1, int i2, int[] ints, int i3) {

    }

    @Override
    public void glHint(int i, int i1) {

    }

    @Override
    public boolean glIsBuffer(int i) {
        return false;
    }

    @Override
    public boolean glIsEnabled(int i) {
        return false;
    }

    @Override
    public boolean glIsFramebuffer(int i) {
        return false;
    }

    @Override
    public boolean glIsRenderbuffer(int i) {
        return false;
    }

    @Override
    public boolean glIsTexture(int i) {
        return false;
    }

    @Override
    public void glLineWidth(float v) {

    }

    @Override
    public ByteBuffer glMapBuffer(int i, int i1) {
        return null;
    }

    @Override
    public ByteBuffer glMapBufferRange(int i, long l, long l1, int i1) {
        return null;
    }

    @Override
    public void glPixelStorei(int i, int i1) {

    }

    @Override
    public void glPolygonOffset(float v, float v1) {

    }

    @Override
    public void glReadPixels(int i, int i1, int i2, int i3, int i4, int i5, Buffer buffer) {

    }

    @Override
    public void glReadPixels(int i, int i1, int i2, int i3, int i4, int i5, long l) {

    }

    @Override
    public void glReadnPixels(int i, int i1, int i2, int i3, int i4, int i5, int i6, Buffer buffer) {

    }

    @Override
    public void glRenderbufferStorage(int i, int i1, int i2, int i3) {

    }

    @Override
    public void glRenderbufferStorageMultisample(int i, int i1, int i2, int i3, int i4) {

    }

    @Override
    public void glSampleCoverage(float v, boolean b) {

    }

    @Override
    public void glScissor(int i, int i1, int i2, int i3) {

    }

    @Override
    public void glStencilFunc(int i, int i1, int i2) {

    }

    @Override
    public void glStencilMask(int i) {

    }

    @Override
    public void glStencilOp(int i, int i1, int i2) {

    }

    @Override
    public void glTexImage2D(int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7, Buffer buffer) {

    }

    @Override
    public void glTexImage2D(int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7, long l) {

    }

    @Override
    public void glTexParameterf(int i, int i1, float v) {

    }

    @Override
    public void glTexParameterfv(int i, int i1, FloatBuffer floatBuffer) {

    }

    @Override
    public void glTexParameterfv(int i, int i1, float[] floats, int i2) {

    }

    @Override
    public void glTexParameteri(int i, int i1, int i2) {

    }

    @Override
    public void glTexParameteriv(int i, int i1, IntBuffer intBuffer) {

    }

    @Override
    public void glTexParameteriv(int i, int i1, int[] ints, int i2) {

    }

    @Override
    public void glTexStorage1D(int i, int i1, int i2, int i3) {

    }

    @Override
    public void glTexStorage2D(int i, int i1, int i2, int i3, int i4) {

    }

    @Override
    public void glTexStorage3D(int i, int i1, int i2, int i3, int i4, int i5) {

    }

    @Override
    public void glTexSubImage2D(int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7, Buffer buffer) {

    }

    @Override
    public void glTexSubImage2D(int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7, long l) {

    }

    @Override
    public void glTextureStorage1DEXT(int i, int i1, int i2, int i3, int i4) {

    }

    @Override
    public void glTextureStorage2DEXT(int i, int i1, int i2, int i3, int i4, int i5) {

    }

    @Override
    public void glTextureStorage3DEXT(int i, int i1, int i2, int i3, int i4, int i5, int i6) {

    }

    @Override
    public boolean glUnmapBuffer(int i) {
        return false;
    }

    @Override
    public void glViewport(int i, int i1, int i2, int i3) {

    }

    @Override
    public boolean isGL() {
        return false;
    }

    @Override
    public boolean isGL4bc() {
        return false;
    }

    @Override
    public boolean isGL4() {
        return false;
    }

    @Override
    public boolean isGL3bc() {
        return false;
    }

    @Override
    public boolean isGL3() {
        return false;
    }

    @Override
    public boolean isGL2() {
        return false;
    }

    @Override
    public boolean isGLES1() {
        return false;
    }

    @Override
    public boolean isGLES2() {
        return false;
    }

    @Override
    public boolean isGLES3() {
        return false;
    }

    @Override
    public boolean isGLES() {
        return false;
    }

    @Override
    public boolean isGL2ES1() {
        return false;
    }

    @Override
    public boolean isGL2ES2() {
        return false;
    }

    @Override
    public boolean isGL2ES3() {
        return false;
    }

    @Override
    public boolean isGL3ES3() {
        return false;
    }

    @Override
    public boolean isGL4ES3() {
        return false;
    }

    @Override
    public boolean isGL2GL3() {
        return false;
    }

    @Override
    public boolean isGL4core() {
        return false;
    }

    @Override
    public boolean isGL3core() {
        return false;
    }

    @Override
    public boolean isGLcore() {
        return false;
    }

    @Override
    public boolean isGLES2Compatible() {
        return false;
    }

    @Override
    public boolean isGLES3Compatible() {
        return false;
    }

    @Override
    public boolean isGLES31Compatible() {
        return false;
    }

    @Override
    public boolean hasGLSL() {
        return false;
    }

    @Override
    public GL getDownstreamGL() throws GLException {
        return null;
    }

    @Override
    public GL getRootGL() throws GLException {
        return null;
    }

    @Override
    public GL getGL() throws GLException {
        return null;
    }

    @Override
    public GL4bc getGL4bc() throws GLException {
        return null;
    }

    @Override
    public GL4 getGL4() throws GLException {
        return null;
    }

    @Override
    public GL3bc getGL3bc() throws GLException {
        return null;
    }

    @Override
    public GL3 getGL3() throws GLException {
        return null;
    }

    @Override
    public GL2 getGL2() throws GLException {
        return null;
    }

    @Override
    public GLES1 getGLES1() throws GLException {
        return null;
    }

    @Override
    public GLES2 getGLES2() throws GLException {
        return null;
    }

    @Override
    public GLES3 getGLES3() throws GLException {
        return null;
    }

    @Override
    public GL2ES1 getGL2ES1() throws GLException {
        return null;
    }

    @Override
    public GL2ES2 getGL2ES2() throws GLException {
        return null;
    }

    @Override
    public GL2ES3 getGL2ES3() throws GLException {
        return null;
    }

    @Override
    public GL3ES3 getGL3ES3() throws GLException {
        return null;
    }

    @Override
    public GL4ES3 getGL4ES3() throws GLException {
        return null;
    }

    @Override
    public GL2GL3 getGL2GL3() throws GLException {
        return null;
    }

    @Override
    public GLProfile getGLProfile() {
        return null;
    }

    @Override
    public GLContext getContext() {
        return null;
    }

    @Override
    public boolean isFunctionAvailable(String s) {
        return false;
    }

    @Override
    public boolean isExtensionAvailable(String s) {
        return false;
    }

    @Override
    public boolean hasBasicFBOSupport() {
        return false;
    }

    @Override
    public boolean hasFullFBOSupport() {
        return false;
    }

    @Override
    public int getMaxRenderbufferSamples() {
        return 0;
    }

    @Override
    public boolean isNPOTTextureAvailable() {
        return false;
    }

    @Override
    public boolean isTextureFormatBGRA8888Available() {
        return false;
    }

    @Override
    public void setSwapInterval(int i) {

    }

    @Override
    public int getSwapInterval() {
        return 0;
    }

    @Override
    public Object getPlatformGLExtensions() {
        return null;
    }

    @Override
    public Object getExtension(String s) {
        return null;
    }

    @Override
    public void glClearDepth(double v) {

    }

    @Override
    public void glDepthRange(double v, double v1) {

    }

    @Override
    public int getBoundBuffer(int i) {
        return 0;
    }

    @Override
    public GLBufferStorage getBufferStorage(int i) {
        return null;
    }

    @Override
    public GLBufferStorage mapBuffer(int i, int i1) throws GLException {
        return null;
    }

    @Override
    public GLBufferStorage mapBufferRange(int i, long l, long l1, int i1) throws GLException {
        return null;
    }

    @Override
    public boolean isVBOArrayBound() {
        return false;
    }

    @Override
    public boolean isVBOElementArrayBound() {
        return false;
    }

    @Override
    public int getBoundFramebuffer(int i) {
        return 0;
    }

    @Override
    public int getDefaultDrawFramebuffer() {
        return 0;
    }

    @Override
    public int getDefaultReadFramebuffer() {
        return 0;
    }

    @Override
    public int getDefaultReadBuffer() {
        return 0;
    }
}
