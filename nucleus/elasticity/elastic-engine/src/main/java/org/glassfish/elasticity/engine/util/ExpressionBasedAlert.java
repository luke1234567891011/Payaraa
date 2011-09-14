/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2009-2011 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package org.glassfish.elasticity.engine.util;

import org.glassfish.elasticity.api.Alert;
import org.glassfish.elasticity.config.serverbeans.AlertConfig;
import org.glassfish.elasticity.metric.MetricAttribute;
import org.glassfish.elasticity.metric.MetricNode;
import org.glassfish.elasticity.metric.TabularMetricAttribute;
import org.glassfish.elasticity.metric.TabularMetricEntry;
import org.jvnet.hk2.annotations.Inject;
import org.jvnet.hk2.component.Habitat;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * A simple Alert that uses an expression
 *
 * @param <C>
 * @author Mahesh Kannan
 */
public class ExpressionBasedAlert<C extends AlertConfig>
        implements Alert<C>, Runnable {

    private C config;

    Habitat habitat;

    public void initialize(Habitat habitat, C config) {
        this.habitat = habitat;
        this.config = config;
    }

    public AlertState execute() {


/*        StringBuilder sb = new StringBuilder("Alert {");
        sb.append("name=").append(config.getName()).append("; ")
           .append("expr=").append(config.getExpression()).append("; ")
           .append("schedule=").append(config.getSchedule()).append("; ")
                .append("}");
        System.out.println("Alert executed with: " + sb.toString());*/

/*
        MetricNode metricNode = null;

        try {
            metricNode = (MetricNode) habitat.getComponent(MetricNode.class, "jvm_memory");


            StringBuilder sb = new StringBuilder("jvm_memory: ");
            if (metricNode != null) {
                for (MetricAttribute ma : metricNode.getAttributes()) {
                    sb.append("*").append(ma.getName()).append("= ");
                    if (ma instanceof TabularMetricAttribute) {
                        sb.append("\n===================================================================\n");
                        TabularMetricAttribute tma = (TabularMetricAttribute) ma;
                        for (String name : tma.getColumnNames()) {
                            sb.append(" | ").append(name).append(" | ");
                        }
                        sb.append("\n===================================================================\n");
                        Iterator<TabularMetricEntry> iter = tma.iterator(120, TimeUnit.SECONDS);
                        for (TabularMetricEntry tme; iter.hasNext(); ) {
                            tme = iter.next();
                            for (String name : tma.getColumnNames()) {
                                sb.append(" | ").append(tme.getValue(name)).append(" | ");
                            }
                            sb.append("\n");
                        }
                    } else {
                        sb.append(ma.getValue());
                    }
                }
            } else {
                sb.append("jvm_memory is NULL");
            }


            System.out.println("*** Executed ExpressionBasedAlert.execute(): \n" + sb.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
*/

        return AlertState.ALARM;
    }

    public void run() {
        execute();
    }

}
