/*
 * Copyright (C) 2013 Peng fei Pan <sky@xiaopan.me>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.xiaopan.android.imageloader.task.display;

import java.io.File;

import me.xiaopan.android.imageloader.decode.FileInputStreamCreator;
import me.xiaopan.android.imageloader.decode.InputStreamCreator;
import me.xiaopan.android.imageloader.task.BitmapLoadCallable;
import me.xiaopan.android.imageloader.task.BitmapLoadTask;
import me.xiaopan.android.imageloader.util.Scheme;

public class FileBitmapDisplayTask extends  BitmapLoadTask {
	
	public FileBitmapDisplayTask(DisplayRequest displayRequest) {
		super(displayRequest, new FileBitmapLoadCallable(displayRequest));
	}
	
	private static class FileBitmapLoadCallable extends BitmapLoadCallable {
		
		public FileBitmapLoadCallable(DisplayRequest displayRequest) {
			super(displayRequest);
		}

		@Override
		public InputStreamCreator getInputStreamCreator() {
			return new FileInputStreamCreator(new File(Scheme.FILE.crop(displayRequest.getImageUri())));
		}

		@Override
		public void onFailed() {
			
		}
	}
}
