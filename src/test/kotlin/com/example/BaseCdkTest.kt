package com.example

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT
import org.junit.jupiter.api.Test
import software.amazon.awscdk.core.App
import java.io.IOException

class BaseCdkTest {
    private val JSON = ObjectMapper().configure(INDENT_OUTPUT, true)

    @Test
    @Throws(IOException::class)
    fun testStack() {
        val app = App()
        val stack = BaseCdkStack(app, "test")

        // synthesize the stack to a CloudFormation template and compare against
        // a checked-in JSON file.
        val actual = JSON.valueToTree<JsonNode>(app.synth().getStackArtifact(stack.artifactId).template)
        assert(ObjectMapper().createObjectNode() == actual)
    }
}
