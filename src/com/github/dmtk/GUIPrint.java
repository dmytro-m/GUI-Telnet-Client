package com.github.dmtk;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

class GUIPrint extends PrintStream {

    private boolean autoFlush = false;
    private boolean trouble = false;
    private BufferedWriter textOut;
    private OutputStreamWriter charOut;
    private GUI gui;

    public GUIPrint(OutputStream out, GUI gui) {
        this(out, false);
        this.gui = gui;
    }

    public GUIPrint(OutputStream out, boolean autoFlush) {

        this(autoFlush, out);
        init(new OutputStreamWriter(this));
    }

    public GUIPrint(boolean autoFlush, OutputStream out) {

        super(out);
        if (out == null) {
            throw new NullPointerException("Null output stream");
        }
        this.autoFlush = autoFlush;

    }

    private void init(OutputStreamWriter osw) {

        this.charOut = osw;
        this.textOut = new BufferedWriter(osw);

    }

    private void ensureOpen() throws IOException {

        if (out == null) {
            throw new IOException("Stream closed");
        }

    }

    @Override
    public void print(String s) {

        if (s == null) {

            s = "null";
        }

        try {

            write(s);
        } catch (NoSuchFieldException | NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(GUIPrint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void write(String s) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        try {

            synchronized (this) {

                ensureOpen();
                textOut.write(s);
                gui.getCLITextArea3().setText(gui.getCLITextArea3().getText() + s);
                Method method = textOut.getClass().getDeclaredMethod("flushBuffer");
                method.setAccessible(true);
                method.invoke(textOut);
                Method method2 = charOut.getClass().getDeclaredMethod("flushBuffer");
                method2.setAccessible(true);
                method2.invoke(charOut);
                if (autoFlush && (((s.indexOf('\n') >= 0))||(!(s.indexOf('\033')>=0)))) {
                    out.flush();
                }
            }
        } catch (InterruptedIOException x) {
            Thread.currentThread().interrupt();
        } catch (IOException x) {
            trouble = true;

        }

    }
}
