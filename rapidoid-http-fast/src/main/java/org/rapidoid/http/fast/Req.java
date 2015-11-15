package org.rapidoid.http.fast;

/*
 * #%L
 * rapidoid-http-fast
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

import java.io.OutputStream;
import java.io.Serializable;
import java.util.Map;

import org.rapidoid.annotation.Authors;
import org.rapidoid.annotation.Since;
import org.rapidoid.net.abstracts.Channel;

@Authors("Nikolche Mihajlovski")
@Since("4.2.0")
public interface Req {

	/* THE LOW-LEVEL COMMUNICATION CHANNEL: */

	Channel channel();

	/* REQUEST METHODS: */

	String verb();

	Req verb(String verb);

	String uri();

	Req uri(String uri);

	String path();

	Req path(String path);

	byte[] body();

	Req body(byte[] body);

	/* IP ADDRESS : */

	String clientIpAddress();

	/* HEADERS: */

	String host();

	String forwardedForAddress();

	/* UNIQUE CONNECTION ID: */

	long connectionId();

	/* UNIQUE REQUEST ID: */

	long requestId();

	/* URL PARAMETERS: */

	Map<String, String> params();

	String param(String name);

	String param(String name, String defaultValue);

	/* REQUEST HEADERS: */

	Map<String, String> headers();

	String header(String name);

	String header(String name, String defaultValue);

	/* REQUEST COOKIES: */

	Map<String, String> cookies();

	String cookie(String name);

	String cookie(String name, String defaultValue);

	/* POSTED PARAMS IN REQUEST BODY: */

	Map<String, Object> posted();

	<T extends Serializable> T posted(String name);

	<T extends Serializable> T posted(String name, T defaultValue);

	/* POSTED FILES IN REQUEST BODY: */

	Map<String, byte[]> files();

	byte[] file(String name);

	byte[] file(String name, byte[] defaultValue);

	/* REQUEST DATA (URL PARAMS + POSTED DATA): */

	/**
	 * Data includes params + posted.
	 */
	Map<String, Object> data();

	/**
	 * Data includes params + posted.
	 */
	<T> T data(String name);

	/**
	 * Data includes params + posted.
	 */
	<T> T data(String name, T defaultValue);

	/* CUSTOM REQUEST ATTRIBUTES: */

	Map<String, Object> attrs();

	<T> T attr(String key);

	<T> T attr(String key, T defaultValue);

	/* RESPONSE: */

	HttpResponse response();

	OutputStream out();

	Req done();

}