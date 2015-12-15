package org.rapidoid.web;

/*
 * #%L
 * rapidoid-web
 * %%
 * Copyright (C) 2014 - 2015 Nikolche Mihajlovski and contributors
 * %%
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
 * #L%
 */

import org.rapidoid.annotation.Authors;
import org.rapidoid.annotation.Since;
import org.rapidoid.http.fast.FastHttp;
import org.rapidoid.http.fast.On;
import org.rapidoid.http.fast.handler.FastHttpHandler;

@Authors("Nikolche Mihajlovski")
@Since("5.0.8")
public class POJO {

	public static FastHttpHandler handler() {
		return handler(new RootWebApp());
	}

	public static FastHttpHandler handler(WebApp app) {
		FastHttp http = On.getDefaultSetup().http();
		return new AppHandler(http, app);
	}

}
