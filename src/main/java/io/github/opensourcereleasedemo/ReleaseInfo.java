/*
Copyright 2021 PJ Fanning

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package io.github.opensourcereleasedemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ReleaseInfo {
    public static String getVersion() {
        URL resourceUrl = ReleaseInfo.class.getResource("/version.txt");
        if (resourceUrl == null) {
            return "Failed to read version.txt";
        } else {
            try (
                    InputStream stream = resourceUrl.openStream();
                    InputStreamReader streamReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
                    StringWriter stringWriter = new StringWriter()
            ) {
                char[] buffer = new char[1024];
                int n;
                while ((n = streamReader.read(buffer)) >= 0) {
                    stringWriter.write(buffer, 0, n);
                }
                return stringWriter.toString();
            } catch (IOException ioException) {
                ioException.printStackTrace();
                return "Failed to read version.txt";
            }
        }
    }
}