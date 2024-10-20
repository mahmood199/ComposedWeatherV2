import SwiftUI
import ComposeApp

@main
struct iOSApp: App {

    init() {
        DIKt.initializeKoin()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}