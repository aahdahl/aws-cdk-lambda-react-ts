package com.example

import software.amazon.awscdk.core.App

object BaseCdkApp {
    @JvmStatic fun main(args: Array<String>) {
        val app = App()
        BaseCdkStack(app, "BaseCdkStack")
        app.synth()
    }
}
