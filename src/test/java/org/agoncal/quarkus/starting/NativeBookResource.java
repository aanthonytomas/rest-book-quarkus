package org.agoncal.quarkus.starting;

import io.quarkus.test.junit.QuarkusIntegrationTest;

@QuarkusIntegrationTest
public class NativeBookResource extends BookResourceTest {
    // No need for an inner class here.
    // The tests defined in BookResourceTest will be run against the native image.
}