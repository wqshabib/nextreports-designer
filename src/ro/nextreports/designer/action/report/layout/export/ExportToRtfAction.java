/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ro.nextreports.designer.action.report.layout.export;

import ro.nextreports.designer.Globals;
import ro.nextreports.designer.util.I18NSupport;
import ro.nextreports.designer.util.ImageUtil;

import ro.nextreports.engine.exporter.ExporterBean;
import ro.nextreports.engine.exporter.ResultExporter;
import ro.nextreports.engine.exporter.RtfExporter;
import ro.nextreports.engine.Report;
import ro.nextreports.engine.ReportRunner;

/**
 * Created by IntelliJ IDEA.
 * User: mihai.panaitescu
 * Date: 24-Feb-2009
 * Time: 12:14:53
 */
public class ExportToRtfAction extends ExportAction {

    public ExportToRtfAction(Report report) {
		super(report, false); // orientation is taken from layout
        exportType = ReportRunner.RTF_FORMAT;
        putValue(NAME, I18NSupport.getString("export.rtf.short.desc"));
		putValue(SMALL_ICON, ImageUtil.getImageIcon("rtf"));
		putValue(MNEMONIC_KEY, new Integer('R'));
		putValue(SHORT_DESCRIPTION, I18NSupport.getString("export.rtf.short.desc"));
		putValue(LONG_DESCRIPTION, I18NSupport.getString("export.rtf.long.desc"));
	}	
	
	@Override
	protected String getFileExtension() {		
		return "rtf";
	}

	@Override
	protected ResultExporter getResultExporter(ExporterBean bean) {
		ResultExporter exporter = new RtfExporter(bean);
		exporter.setImageChartPath(Globals.USER_DATA_DIR + "/reports");
		return exporter;
	}
}
