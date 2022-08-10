package com.base.mvp.core.data.remote;

public final class ApiEndPoint {

    private static final String BASE_URL = "";

    public static final String ENDPOINT_FOR_EXAMPLE = BASE_URL
            + "/endpoint/for_example";

    public static final String ENDPOINT_FOR_EXAMPLE_2 = BASE_URL
            + "/endpoint/for_example_2";

    private ApiEndPoint() {
        // This class is not publicly instantiable
    }
}
