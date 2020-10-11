package com.example

import com.example.services.EmptyService
import software.amazon.awscdk.core.Construct
import software.amazon.awscdk.core.Stack
import software.amazon.awscdk.core.StackProps

class BaseCdkStack(scope: Construct, id: String, props: StackProps? = null) : Stack(scope, id, props) {
    init {
        EmptyService(this, "Widgets");
    }
}
