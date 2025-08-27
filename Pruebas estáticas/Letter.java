package com.pigpen;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Letter {

    /**
     * @web https://www.jc-mouse.net/
     * @author Mouse
     */
         private Point point                 =       new Point(0,0);
        private final int SIZE_BOX          =       24;
        //tamaño y posicion de letra
        private int x                       =       0;
        private int y                       =       0;
        private final int WIDTH             =       16;
        private final int HEIGHT            =       16;
        //
        private final Font FONT_CHAR        =       new Font("Tahoma", Font.BOLD, 16 );
        private Dimension dimensionText;
        private String letter               =       "A";
        private final Color COLOR_CHAR            =       new Color(0,0,0);
        private final Stroke STROKE_CHAR    =       new BasicStroke(2f);
        private final Stroke STROKE_0       =       new BasicStroke(0);

        /**
         * Constructor de clase
         * @param letter letra de A..Z o cualquier otro caracter, si no es A..z no se cifra
         */
        public Letter(String letter){
            this.letter = letter;
            x = point.x+4;
            y = point.y+4;
        }

        /**
         * Constructor de clase
         * @param letter letra de A..Z o cualquier otro caracter, si no es A..z no se cifra
         * @param point coordenada X,Y de letra/caracter
         */
        public Letter(String letter, Point point){
            this.letter = letter.toUpperCase();
            this.point = point;
            x = point.x+4;
            y = point.y+4;
        }

        /**
         * Metodo para pintar una letra pigpen/caracter
         * @param g2
         */
        public void drawLetter(Graphics2D g2){
            g2.setStroke(STROKE_CHAR);
            g2.setColor( COLOR_CHAR );
            if(letter.equals("A") || letter.equals("J") ){
                g2.drawLine(x, y+HEIGHT, x+WIDTH, y+HEIGHT); //  _
                g2.drawLine(x+WIDTH, y, x+WIDTH, y+HEIGHT);  //   |
                if(letter.equals("J")){
                    g2.setStroke(STROKE_0);
                    g2.fillRect(x+WIDTH-8, y+HEIGHT-8,6, 6);
                }
            } else if(letter.equals("B") || letter.equals("K") ){
                g2.drawLine(x, y, x, y+HEIGHT);              // |
                g2.drawLine(x, y+HEIGHT, x+WIDTH, y+HEIGHT); //  _
                g2.drawLine(x+WIDTH, y, x+WIDTH, y+HEIGHT);  //   |
                if(letter.equals("K")){
                    g2.setStroke(STROKE_0);
                    g2.fillRect(x+WIDTH/2-3, y+HEIGHT-8,6, 6);
                }
            } else if(letter.equals("C") || letter.equals("L")){
                g2.drawLine(x, y, x, y+HEIGHT);              // |
                g2.drawLine(x, y+HEIGHT, x+WIDTH, y+HEIGHT); // _
                if(letter.equals("L")){
                    g2.setStroke(STROKE_0);
                    g2.fillRect(x+2, y+HEIGHT-8,6, 6);
                }
            } else if(letter.equals("D") || letter.equals("M")){
                g2.drawLine(x, y, x+WIDTH, y);               // -
                g2.drawLine(x, y+HEIGHT, x+WIDTH, y+HEIGHT);
                g2.drawLine(x+WIDTH, y, x+WIDTH, y+HEIGHT);
                if(letter.equals("M")){
                    g2.setStroke(STROKE_0);
                    g2.fillRect(x+WIDTH-8, y+HEIGHT/2-3,6, 6);
                }
            }else if(letter.equals("E") || letter.equals("N")){
                g2.drawLine(x, y, x+WIDTH, y);               // -
                g2.drawLine(x, y, x, y+HEIGHT);              // |
                g2.drawLine(x, y+HEIGHT, x+WIDTH, y+HEIGHT); //  _
                g2.drawLine(x+WIDTH, y, x+WIDTH, y+HEIGHT);  //   |
                if(letter.equals("N")){
                    g2.setStroke(STROKE_0);
                    g2.fillRect(x+WIDTH/2-3, y+HEIGHT-8,6, 6);
                }
            }else if(letter.equals("F") || letter.equals("O")){
                g2.drawLine(x, y, x+WIDTH, y);               // -
                g2.drawLine(x, y, x, y+HEIGHT);              // |
                g2.drawLine(x, y+HEIGHT, x+WIDTH, y+HEIGHT); //  _
                if(letter.equals("O")){
                    g2.setStroke(STROKE_0);
                    g2.fillRect(x+2, y+HEIGHT/2-3,6, 6);
                }
            }else if(letter.equals("G") || letter.equals("P")){
                g2.drawLine(x, y, x+WIDTH, y);               // -
                g2.drawLine(x+WIDTH, y, x+WIDTH, y+HEIGHT);
                if(letter.equals("P")){
                    g2.setStroke(STROKE_0);
                    g2.fillRect(x+WIDTH-8, y+2,6, 6);
                }
            }else if(letter.equals("H") || letter.equals("Q")){
                g2.drawLine(x, y, x+WIDTH, y);               // -
                g2.drawLine(x, y, x, y+HEIGHT);              // |
                g2.drawLine(x+WIDTH, y, x+WIDTH, y+HEIGHT);  //   |
                if(letter.equals("Q")){
                    g2.setStroke(STROKE_0);
                    g2.fillRect(x+WIDTH/2-3, y+2,6, 6);
                }
            }else if(letter.equals("I") || letter.equals("R")){
                g2.drawLine(x, y, x+WIDTH, y);               // -
                g2.drawLine(x, y, x, y+HEIGHT);              // |
                if(letter.equals("R")){
                    g2.setStroke(STROKE_0);
                    g2.fillRect(x+2, y+2,6, 6);
                }
            }else if(letter.equals("T") || letter.equals("X")){    //>
                g2.drawLine(x, y, x+WIDTH, y+HEIGHT/2);
                g2.drawLine(x, y+HEIGHT, x+WIDTH, y+HEIGHT/2);
                if(letter.equals("X")){
                    g2.setStroke(STROKE_0);
                    g2.fillRect(x, y+HEIGHT/2-3,6, 6);
                }
            }else if(letter.equals("U") || letter.equals("Y")){ //<
                g2.drawLine(x, y+HEIGHT/2, x+WIDTH, y);
                g2.drawLine(x, y+HEIGHT/2, x+WIDTH, y+HEIGHT);
                if(letter.equals("Y")){
                    g2.setStroke(STROKE_0);
                    g2.fillRect(x+WIDTH-6, y+HEIGHT/2-3,6, 6);
                }
            }else if(letter.equals("S") || letter.equals("W")){ // \/
                g2.drawLine(x, y, x+WIDTH/2, y+HEIGHT);
                g2.drawLine(x+WIDTH, y, x+WIDTH/2, y+HEIGHT);
                if(letter.equals("W")){
                    g2.setStroke(STROKE_0);
                    g2.fillRect(x+WIDTH/2-3, y,6, 6);
                }
            }else if(letter.equals("V") || letter.equals("Z")){ // /\
                g2.drawLine(x+WIDTH/2, y, x, y+HEIGHT);
                g2.drawLine(x+WIDTH/2, y, x+WIDTH, y+HEIGHT);
                if(letter.equals("Z")){
                    g2.setStroke(STROKE_0);
                    g2.fillRect(x+WIDTH/2-3, y+HEIGHT-8,6, 6);
                }
            }else{// si no corresponde a ninguna letra de A..Z pinta el original
                //que puede ser una letra con acento, un numero u otro caracter especial
                if(letter.length()>0){
                    dimensionText = calculateFontDimension(letter);
                    g2.setFont(FONT_CHAR);
                    g2.drawString( letter, point.x+SIZE_BOX/2-dimensionText.width/2, point.y + SIZE_BOX/2 + dimensionText.height/2);
                }
            }

        }

        /**
         * Pinta una letra de A..Z en java2d
         * @param g2
         */
        public void paintLetter(Graphics2D g2){
            g2.setColor( COLOR_CHAR );
            dimensionText = calculateFontDimension(letter);
            g2.setFont(FONT_CHAR);
            g2.drawString( letter, point.x+SIZE_BOX/2-dimensionText.width/2, point.y + SIZE_BOX/2 + dimensionText.height/2);
        }

        /**
         * Metodo que retorna una imagen
         * @param band si
         *  TRUE: retorna letra cifrada
         *  FALSE: retorna letra sin cifrar
         * @return BufferedImage
         */
        public BufferedImage getImage(boolean band){
            BufferedImage bufferedImage = new BufferedImage(SIZE_BOX, SIZE_BOX, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = bufferedImage.createGraphics();
            g2d.setColor( new Color(255,255,255));
            g2d.fill(new Rectangle2D.Double(0,0,SIZE_BOX,SIZE_BOX));
            if(band)
                drawLetter(g2d);
            else
                paintLetter(g2d);
            g2d.dispose();
            return bufferedImage;
        }


        /**
         * Obtiene las dimensiones de un texto
         * @param text
         * @return Dimension
         */
        public Dimension calculateFontDimension(String text){
            BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = image.createGraphics();
            g2.setStroke(STROKE_0);
            TextLayout layout = new TextLayout(text, FONT_CHAR, g2.getFontRenderContext());
            layout.draw(g2, 0, 0);
            Rectangle2D bounds = layout.getBounds();
            bounds.setRect(bounds.getX(),
                    bounds.getY(),
                    bounds.getWidth(),
                    bounds.getHeight());
            int w = (int) bounds.getWidth();
            int h = (int) bounds.getHeight();
            g2.draw(bounds);
            g2.dispose();
            return new Dimension(w,h);
        }

    }
}