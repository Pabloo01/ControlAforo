/*
 * Copyright 2020 Noelia Cremades Gómez - noelia.cremades.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Random;
import java.util.Locale;

/**
 *
 * @author Noelia Cremades Gómez - noelia.cremades.alum@iescamp.es
 */
public class Main {

    public static final Random RND = new Random();

    public static void main(String[] args) {
        //DEFINICIÓN DE CONSTANTES
        final int NUM_DIAS = 7;
        final int AFORO_MAX = 1234;
        final int AFORO_MIN = 0;

        //DEFINICIÓN DE LAS VARIABLES 
        int aforo;
        int aforoSemanal = 0;
        int aforoMedio;
        int aforoMax = AFORO_MIN;
        int aforoMin = AFORO_MAX;

        String dia = "Lunes    ";
        String diaMax = "Lunes";
        String diaMin = "Lunes";

        double aforoMedioPorcentaje;
        double aforoMaxPorcentaje;
        double aforoMinPorcentaje;

        //CÓDIGO 
        System.out.println("CINES DEL CENTRO COMERCIAL XeKeBó - CONTROL DE AFORO");
        System.out.println("====================================================");

        for (int i = 0; i < NUM_DIAS; i++) {
            aforo = RND.nextInt(AFORO_MAX - AFORO_MIN + 1) + AFORO_MIN;
            aforoSemanal += aforo;
            if (i == 1) {
                dia = "Martes   ";
            }
            if (i == 2) {
                dia = "Miércoles";
            }
            if (i == 3) {
                dia = "Jueves   ";
            }
            if (i == 4) {
                dia = "Viernes  ";
            }
            if (i == 5) {
                dia = "Sábado   ";
            }
            if (i == 6) {
                dia = "Domingo  ";
            }
            System.out.printf("%s  - Aforo ....: %4d personas%n", dia, aforo);

            if (aforo < aforoMin) {
                aforoMin = aforo;
                diaMax = dia;
            }
            if (aforo > aforoMax) {
                aforoMax = aforo;
                diaMin = dia;
            }
        }
        //SEPARADOR 
        System.out.println("---");

        //AFORO SEMANAL
        System.out.printf("Aforo semanal .........: %4d personas%n",
                aforoSemanal);

        //AFORO MEDIO DIARIO Y SU PORCENTAJE
        aforoMedio = aforoSemanal / NUM_DIAS;
        aforoMedioPorcentaje = (aforoMedio * 100) / AFORO_MAX;
        System.out.printf(Locale.ENGLISH, "Aforo medio diario ....: "
                + "%4d personas  (%.2f%%)%n", aforoMedio, aforoMedioPorcentaje);

        //SEPARADOR 
        System.out.println("---");

        //DIA DE MÁXIMO AFORO
        aforoMaxPorcentaje = (aforoMax * 100) / AFORO_MAX;
        System.out.printf(Locale.ENGLISH, "Día de máximo aforo ..: "
                + "%4d personas  (%5.2f%%) - %s%n",
                aforoMax, aforoMaxPorcentaje, diaMax);
        //DIA DE MÍNIMO AFORO
        aforoMinPorcentaje = (aforoMin * 100) / AFORO_MAX;
        System.out.printf(Locale.ENGLISH, "Día de mínimo aforo ..:"
                + " %4d personas  (%5.2f%%) - %s%n",
                aforoMin, aforoMinPorcentaje, diaMin);
    }

}
