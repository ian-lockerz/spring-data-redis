/*
 * Copyright 2010-2011 the original author or authors.
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

package org.springframework.data.redis.connection.jredis;

import org.jredis.JRedis;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.data.redis.SettingsUtils;
import org.springframework.data.redis.connection.AbstractConnectionIntegrationTests;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jredis.JredisConnectionFactory;

public class JRedisConnectionIntegrationTests extends AbstractConnectionIntegrationTests {

	JredisConnectionFactory factory;

	public JRedisConnectionIntegrationTests() {
		factory = new JredisConnectionFactory();
		factory.setPort(SettingsUtils.getPort());
		factory.setHostName(SettingsUtils.getHost());

		factory.setUsePool(true);
		factory.afterPropertiesSet();
	}

	
	protected RedisConnectionFactory getConnectionFactory() {
		return factory;
	}

	@Test
	public void testRaw() throws Exception {
		JRedis jr = (JRedis) factory.getConnection().getNativeConnection();

		System.out.println(jr.dbsize());
		System.out.println(jr.exists("foobar"));
		jr.set("foobar", "barfoo");
		System.out.println(jr.get("foobar"));
	}

	@Ignore("JRedis does not support pipelining")
	public void testNullCollections() {
	}

	@Ignore
	public void testNullKey() throws Exception {
	}

	@Ignore
	public void testNullValue() throws Exception {
	}

	@Ignore
	public void testHashNullKey() throws Exception {
	}

	@Ignore
	public void testHashNullValue() throws Exception {
	}

	@Ignore
	public void testNullSerialization() throws Exception {
	}

	@Ignore
	public void testPubSub() throws Exception {
	}

	@Ignore
	public void testPubSubWithPatterns() {
	}

	@Ignore
	public void testPubSubWithNamedChannels() {

	}
}