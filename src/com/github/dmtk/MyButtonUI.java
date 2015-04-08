package com.github.dmtk;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicToggleButtonUI;

public class MyButtonUI extends BasicToggleButtonUI {

    public static final float defaultMouseoverTransparency = 0.4f;
    public static final int maxRounding = 8;
    public static final int midRounding = 6;

    public static final Stroke focusStroke
            = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 5,
                    new float[]{3, 3}, 0);

    public static Color buttonBg =new Color(139,203,250);//(193,222,236);// new Color(205, 205, 225);

    private AbstractButton button;

    private Color topBg = new Color(255, 255, 255, 128);
    private Color bg = Color.WHITE;
    private boolean alwaysDrawFocus = false;

    private Color borderColor =new Color(139,203,250); //Color.LIGHT_GRAY;
    private Color selectedBorderColor = Color.GRAY;

    private boolean alwaysDrawBackground = false;
    private Color staticTopBg = new Color(240, 240, 240);//Color.WHITE;
    private Color disabledStaticTopBg = Color.WHITE;
    private Color staticBottomBg = new Color(245, 247, 249);
    private Color disabledStaticBottomBg = new Color(245, 245, 245);

    private Color staticBorderColor = new Color(180, 180, 180);
    private Color staticDisabledBorderColor = new Color(230, 230, 230);

    private static final int maxFadeTimes = 16;

    private boolean mouseOver = false;
    private float mouseoverTransparency = defaultMouseoverTransparency;

    private Timer fadeOutTimer;
    private float fadeTime = maxFadeTimes;

    private boolean sharpTopLeft = false;
    private boolean sharpTopRight = false;
    private boolean sharpBottomLeft = false;
    private boolean sharpBottomRight = false;

    public MyButtonUI(final AbstractButton button) {
        this(button, true, defaultMouseoverTransparency);
    }

    public MyButtonUI(final AbstractButton button, final boolean changeForeground) {
        this(button, changeForeground, defaultMouseoverTransparency);
    }

    public MyButtonUI(final AbstractButton button, float mouseoverTransparency) {
        this(button, true, mouseoverTransparency);
    }

    public MyButtonUI(final AbstractButton button, final boolean changeForeground,
            float mouseoverTransparency) {
        super();

        this.button = button;
        this.mouseoverTransparency = mouseoverTransparency;

        button.setBorderPainted(false);
        button.setOpaque(false);

        final Color foreground = button.getForeground();
        if (changeForeground) {
            button.setForeground(button.isSelected() ? foreground : Color.WHITE);
        }

        fadeOutTimer = new Timer(1000 / 24, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fadeTime++;
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        button.repaint();
                    }
                });

                if (fadeTime == maxFadeTimes) {
                    fadeOutTimer.stop();
                }
            }
        });
        button.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (button.isSelected()) {
                    fadeOutTimer.stop();
                    fadeTime = 1;
                    if (changeForeground) {
                        button.setForeground(foreground);
                    }
                } else {
                    if (changeForeground) {
                        button.setForeground(Color.WHITE);
                    }
                    fadeTime = 1;
                    fadeOutTimer.restart();
                }
            }
        });
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                mouseOver = true;
                fadeOutTimer.stop();
                fadeTime = 1;
                button.repaint();
            }

            public void mouseExited(MouseEvent e) {
                dropMouseOver();
            }
        });
    }

    public void dropMouseOver() {
        mouseOver = false;
        fadeTime = 1;
        fadeOutTimer.restart();
    }

    public void setColor(Color color, int alpha) {
        this.topBg = new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
        this.bg = color;
    }

    public void setStaticColor(Color topBg, Color bottomBg) {
        this.staticTopBg = topBg;
        this.staticBottomBg = bottomBg;
        this.disabledStaticTopBg = topBg;
        this.disabledStaticBottomBg = new Color(Math.min(255, bottomBg.getRed() + 5),
                Math.min(255, bottomBg.getGreen() + 5),
                Math.min(255, bottomBg.getBlue() + 5));
    }

    public void setStaticBorderColor(Color staticBorderColor, Color staticDisabledBorderColor) {
        this.staticBorderColor = staticBorderColor;
        this.staticDisabledBorderColor = staticDisabledBorderColor;
    }

    public void setBorderColor(Color borderColor, Color selectedBorderColor) {
        this.borderColor = borderColor;
        this.selectedBorderColor = selectedBorderColor;
    }

    public void setInnerBorderColor(Color borderColor, Color selectedBorderColor) {
        this.borderColor = borderColor;
        this.selectedBorderColor = selectedBorderColor;
    }

    public Color getTopBg() {
        return topBg;
    }

    public Color getBg() {
        return bg;
    }

    public void setRoundedSides(java.util.List<Integer> rounded) {
        setSharpTopLeft(!rounded.contains(1) && !rounded.contains(-1));
        setSharpTopRight(!rounded.contains(2) && !rounded.contains(-1));
        setSharpBottomLeft(!rounded.contains(3) && !rounded.contains(-1));
        setSharpBottomRight(!rounded.contains(4) && !rounded.contains(-1));
    }

    public java.util.List<Integer> getRoundedSides() {
        java.util.List<Integer> rounded = new ArrayList<Integer>();
        if (!isSharpTopLeft() && !isSharpBottomRight() && !isSharpBottomLeft()
                && !isSharpBottomRight()) {
            rounded.add(-1);
        } else if (isSharpTopLeft() && isSharpBottomRight() && isSharpBottomLeft()
                && isSharpBottomRight()) {
            rounded.add(0);
        } else {
            if (!isSharpTopLeft()) {
                rounded.add(1);
            }
            if (!isSharpTopRight()) {
                rounded.add(2);
            }
            if (!isSharpBottomLeft()) {
                rounded.add(3);
            }
            if (!isSharpBottomRight()) {
                rounded.add(4);
            }
        }
        return rounded;
    }

    public boolean isSharpBottomLeft() {
        return sharpBottomLeft;
    }

    public void setSharpBottomLeft(boolean sharpBottomLeft) {
        this.sharpBottomLeft = sharpBottomLeft;
    }

    public boolean isSharpBottomRight() {
        return sharpBottomRight;
    }

    public void setSharpBottomRight(boolean sharpBottomRight) {
        this.sharpBottomRight = sharpBottomRight;
    }

    public boolean isSharpTopLeft() {
        return sharpTopLeft;
    }

    public void setSharpTopLeft(boolean sharpTopLeft) {
        this.sharpTopLeft = sharpTopLeft;
    }

    public boolean isSharpTopRight() {
        return sharpTopRight;
    }

    public void setSharpTopRight(boolean sharpTopRight) {
        this.sharpTopRight = sharpTopRight;
    }

    public void setAllSharp(boolean sharp) {
        this.sharpTopLeft = sharp;
        this.sharpTopRight = sharp;
        this.sharpBottomLeft = sharp;
        this.sharpBottomRight = sharp;
    }

    public boolean isAlwaysDrawFocus() {
        return alwaysDrawFocus;
    }

    public void setAlwaysDrawFocus(boolean alwaysDrawFocus) {
        this.alwaysDrawFocus = alwaysDrawFocus;
    }

    public boolean isAlwaysDrawBackground() {
        return alwaysDrawBackground;
    }

    public void setAlwaysDrawBackground(boolean alwaysDrawBackground) {
        this.alwaysDrawBackground = alwaysDrawBackground;
    }

    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        Object aa = g2d.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        ButtonModel model = ((AbstractButton) c).getModel();

        // Создаем три полигона бордеров
        GeneralPath gp0 = new GeneralPath();
        GeneralPath gp1 = new GeneralPath();
        GeneralPath gp2 = new GeneralPath();
        if (!sharpTopLeft) {
            gp0.moveTo(0, maxRounding / 2);
            gp0.quadTo(0, 0, maxRounding / 2, 0);
            gp1.moveTo(1, 1 + midRounding / 2);
            gp1.quadTo(1, 1, 1 + midRounding / 2, 1);
            gp2.moveTo(2, 2 + midRounding / 2);
            gp2.quadTo(2, 2, 2 + midRounding / 2, 2);
        } else {
            gp0.moveTo(0, 0);
            gp1.moveTo(1, 1);
            gp2.moveTo(2, 2);
        }
        if (!sharpTopRight) {
            gp0.lineTo(c.getWidth() - maxRounding / 2 - 1, 0);
            gp0.quadTo(c.getWidth() - 1, 0, c.getWidth() - 1, maxRounding / 2);
            gp1.lineTo(c.getWidth() - midRounding / 2 - 2, 1);
            gp1.quadTo(c.getWidth() - 2, 1, c.getWidth() - 2, 1 + midRounding / 2);
            gp2.lineTo(c.getWidth() - midRounding / 2 - 3, 2);
            gp2.quadTo(c.getWidth() - 3, 2, c.getWidth() - 3, 2 + midRounding / 2);
        } else {
            gp0.lineTo(c.getWidth() - 1, 0);
            gp1.lineTo(c.getWidth() - 2, 1);
            gp2.lineTo(c.getWidth() - 3, 2);
        }
        if (!sharpBottomRight) {
            gp0.lineTo(c.getWidth() - 1, c.getHeight() - maxRounding / 2 - 1);
            gp0.quadTo(c.getWidth() - 1, c.getHeight() - 1, c.getWidth() - maxRounding / 2 - 1,
                    c.getHeight() - 1);
            gp1.lineTo(c.getWidth() - 2, c.getHeight() - midRounding / 2 - 2);
            gp1.quadTo(c.getWidth() - 2, c.getHeight() - 2, c.getWidth() - midRounding / 2 - 2,
                    c.getHeight() - 2);
            gp2.lineTo(c.getWidth() - 3, c.getHeight() - midRounding / 2 - 3);
            gp2.quadTo(c.getWidth() - 3, c.getHeight() - 3, c.getWidth() - midRounding / 2 - 3,
                    c.getHeight() - 3);
        } else {
            gp0.lineTo(c.getWidth() - 1, c.getHeight() - 1);
            gp1.lineTo(c.getWidth() - 2, c.getHeight() - 2);
            gp2.lineTo(c.getWidth() - 3, c.getHeight() - 3);
        }
        if (!sharpBottomLeft) {
            gp0.lineTo(maxRounding / 2, c.getHeight() - 1);
            gp0.quadTo(0, c.getHeight() - 1, 0, c.getHeight() - maxRounding / 2 - 1);
            gp1.lineTo(1 + midRounding / 2, c.getHeight() - 2);
            gp1.quadTo(1, c.getHeight() - 2, 1, c.getHeight() - midRounding / 2 - 2);
            gp2.lineTo(2 + midRounding / 2, c.getHeight() - 3);
            gp2.quadTo(2, c.getHeight() - 3, 2, c.getHeight() - midRounding / 2 - 3);
        } else {
            gp0.lineTo(0, c.getHeight() - 1);
            gp1.lineTo(1, c.getHeight() - 2);
            gp2.lineTo(2, c.getHeight() - 3);
        }
        if (!sharpTopLeft) {
            gp0.lineTo(0, maxRounding / 2);
            gp1.lineTo(1, 1 + midRounding / 2);
            gp2.lineTo(2, 2 + midRounding / 2);
        } else {
            gp0.lineTo(0, 0);
            gp1.lineTo(1, 1);
            gp2.lineTo(2, 2);
        }

        // Статичный фон
        if (alwaysDrawBackground) {
            g2d.setPaint(
                    new GradientPaint(0, 0, c.isEnabled() ? staticTopBg : disabledStaticTopBg, 0,
                            c.getHeight(),
                            c.isEnabled() ? staticBottomBg : disabledStaticBottomBg));
            g2d.fill(gp0);
            g2d.setPaint(c.isEnabled() ? staticBorderColor : staticDisabledBorderColor);
            g2d.draw(gp0);
        }

        if (c.isEnabled()) {
            // Рисуем фон
            Composite composite = g2d.getComposite();
            if (model.isSelected() || model.isArmed()) {
                g2d.setPaint(new GradientPaint(c.getWidth() / 3, c.getHeight() / 3, topBg,
                        c.getWidth(), c.getHeight(), bg));
                g2d.fill(gp0);
            } else if (mouseOver || fadeTime != maxFadeTimes) {
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                        mouseoverTransparency * (maxFadeTimes - fadeTime) / maxFadeTimes));
                g2d.setPaint(bg);
                g2d.fill(gp0);
                if (mouseOver) {
                    g2d.setComposite(composite);
                } else {
                    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                            1f * (maxFadeTimes - fadeTime) / maxFadeTimes));
                }
            }

            // Рисуем фокус
            if (c.isFocusOwner() || alwaysDrawFocus) {
                Composite cc = g2d.getComposite();
                g2d.setComposite(composite);
                Stroke s = g2d.getStroke();

                g2d.setStroke(focusStroke);
                g2d.setPaint(c.isFocusOwner() ? Color.GRAY : bg);

                // Внутренний бордер
                g2d.draw(gp2);

                // Внешний бордер
                if (alwaysDrawFocus) {
                    g2d.setStroke(s);
                }
                g2d.draw(gp0);

                if (!alwaysDrawFocus) {
                    g2d.setStroke(s);
                }
                g2d.setComposite(cc);
            }

            // Рисуем кайму
            if (model.isSelected() || model.isArmed() || mouseOver || fadeTime != maxFadeTimes) {
                g2d.setPaint(model.isSelected() ? selectedBorderColor : borderColor);
                g2d.draw(gp0);
                g2d.setPaint(model.isPressed() ? bg : Color.WHITE);
                g2d.draw(gp1);
            }

            // Возвращаем исходный композит
            g2d.setComposite(composite);
        }

        // Возвращаем исходный антиалиасинг
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, aa);

        // Для отрисовки эффекта нажатия
        if (model.isPressed()) {
            g2d.translate(1, 1);
        }

        // Отрисовка текста и изорбажения
        super.paint(g, c);
    }


    /*
     * Методы для упрощения стилизации кнопок
     */
    public static MyButtonUI setupButtonUI(AbstractButton button) {
        return setupButtonUI(button, -1);
    }

    public static MyButtonUI setupButtonUI(AbstractButton button, Insets insets) {
        return setupButtonUI(button, -1, insets);
    }

    public static MyButtonUI setupButtonUI(AbstractButton button, int rounded) {
        return setupButtonUI(button, Arrays.asList(rounded));
    }

    public static MyButtonUI setupButtonUI(AbstractButton button, int rounded, Insets insets) {
        return setupButtonUI(button, Arrays.asList(rounded), insets);
    }

    public static MyButtonUI setupButtonUI(AbstractButton button,
            java.util.List<Integer> rounded) {
        return setupButtonUI(button, rounded, new Insets(4, 4, 4, 4));
    }

    public static MyButtonUI setupButtonUI(AbstractButton button, java.util.List<Integer> rounded,
            Insets insets) {
        MyButtonUI stbui = new MyButtonUI(button, false);
        stbui.setColor(buttonBg, 128);
        stbui.setRoundedSides(rounded);
        stbui.setAlwaysDrawBackground(true);
        button.setUI(stbui);
        button.setMargin(insets);
        button.setBorder(BorderFactory
                .createEmptyBorder(insets.top, insets.left, insets.bottom, insets.right));
        return stbui;
    }

    public static MyButtonUI setupDialogButtonUI(AbstractButton button, int rounded) {
        return setupDialogButtonUI(button, Arrays.asList(rounded));
    }

    public static MyButtonUI setupDialogButtonUI(AbstractButton button,
            java.util.List<Integer> rounded) {
        return setupDialogButtonUI(button, rounded, new Insets(4, 12, 4, 12));
    }

    public static MyButtonUI setupDialogButtonUI(AbstractButton button, int rounded,
            Insets insets) {
        return setupDialogButtonUI(button, Arrays.asList(rounded), insets);
    }

    public static MyButtonUI setupDialogButtonUI(AbstractButton button,
            java.util.List<Integer> rounded, Insets insets) {
        MyButtonUI gbui = setupButtonUI(button, rounded, insets);
        gbui.setStaticBorderColor(new Color(155, 155, 155), new Color(175, 175, 175));
        gbui.setStaticColor(new Color(210, 210, 210), new Color(175, 175, 175));
        return gbui;
    }
}

