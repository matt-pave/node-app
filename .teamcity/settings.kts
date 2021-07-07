package NodeApp.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.dockerCommand
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs

object NodeApp_Build : BuildType({
    uuid = "4331b12d-ea68-4a69-a209-1459e3441a49"
    name = "Build"

    vcs {
        root(NodeApp.vcsRoots.NodeApp_HttpsGithubComMattPaveNodeAppRefsHeadsMain)
    }
steps {
    script {
        name = "NPM"
        scriptContent = "npm install"
        dockerImagePlatform = ScriptBuildStep.ImagePlatform.Linux
        dockerPull = true
        dockerImage = "node:current-alpine3.11"
    }
    dockerCommand {
        commandType = push {
            namesAndTags = "gcr.io/trove-equity/node-app:new"
        }
    }
    dockerCommand {
        name = "Push"
        commandType = push {
            namesAndTags = "gcr.io/trove-equity/node-app:new"
        }
    }
}
    triggers {
        vcs {
        }
    }
})