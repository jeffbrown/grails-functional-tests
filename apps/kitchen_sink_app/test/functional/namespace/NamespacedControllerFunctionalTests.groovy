package namespace

class NamespacedControllerFunctionalTests extends functionaltestplugin.FunctionalTestCase {

    void testControllerNamespaceAsVariableInUrlMapping() {
        get '/primary/namespaced'
        assertStatus 200
        assertContentContains 'Rendered by the index action in the namespace.alpha.NamespacedController controller'

        get '/primary/namespaced/demo'
        assertStatus 200
        assertContentContains 'Rendered by the demo action in the namespace.alpha.NamespacedController controller'

        get '/secondary/namespaced'
        assertStatus 200
        assertContentContains 'Rendered by the index action in the namespace.beta.NamespacedController controller'

        get '/secondary/namespaced/demo'
        assertStatus 200
        assertContentContains 'Rendered by the demo action in the namespace.beta.NamespacedController controller'
    }

    void testControllerNamespaceWithHardcodedNamespaceInUrlMapping() {
        get '/invokePrimaryController'
        assertStatus 200
        assertContentContains 'Rendered by the index action in the namespace.alpha.NamespacedController controller'

        get '/invokeSecondaryController'
        assertStatus 200
        assertContentContains 'Rendered by the index action in the namespace.beta.NamespacedController controller'
    }

    void testNonNamespacedControllerWithSameNameAsNamespacedControllers() {
        get '/nonNamespacedController'
        assertStatus 200
        assertContentContains 'Rendered by the index action in the namespace.gamma.NamespacedController controller'

        get '/nonNamespacedController/index'
        assertStatus 200
        assertContentContains 'Rendered by the index action in the namespace.gamma.NamespacedController controller'

        get '/namespaced'
        assertStatus 200
        assertContentContains 'Rendered by the index action in the namespace.gamma.NamespacedController controller'

        get '/nonNamespacedController/demo'
        assertStatus 200
        assertContentContains 'Rendered by the demo action in the namespace.gamma.NamespacedController controller'

        get '/namespaced/demo'
        assertStatus 200
        assertContentContains 'Rendered by the demo action in the namespace.gamma.NamespacedController controller'
    }
}

