package apis;

import apis.console.ConsoleType;
import apis.console.JavaConsole;
import apis.console.NullConsole;
import apis.errorHandler.ErrorHandlerType;
import apis.errorHandler.JavaErrorHandler;
import apis.errorHandler.NullErrorHandler;
import apis.loader.JavaFileLoader;
import apis.loader.Loader;
import apis.loader.LoaderType;
import apis.loader.NullFileLoader;
import apis.renderer.NullRenderer;
import apis.renderer.OpenGLRenderer;
import apis.renderer.RendererType;
import apis.shaderManager.GLSLShader;
import apis.shaderManager.NullShader;
import apis.shaderManager.ShaderType;
import apis.windowManager.GLFWWindow;
import apis.windowManager.NullWindow;
import apis.windowManager.WindowType;
import dataTypes.ModelData;

public class ApiHandler {
	public static void init(String configFile) {
		consoles[0] = new JavaConsole();
		consoles[1] = new NullConsole();

		errorHandlers[0] = new JavaErrorHandler();
		errorHandlers[1] = new NullErrorHandler();

		loaders[0] = new JavaFileLoader();
		loaders[1] = new NullFileLoader();

		Loader.loadConfig(configFile);

		shaders[0] = new GLSLShader();
		shaders[1] = new NullShader();

		windows[0] = new GLFWWindow();
		windows[1] = new NullWindow();

		windows[0].init();

		renderers[0] = new OpenGLRenderer();
		renderers[1] = new NullRenderer();

		// Renderer is inited in the create window method (ensures that GL capabilities have been created)
	}

	public static void cleanup() {
		ModelData data = new ModelData(new double[0], new int[0]);
		data.cleanup();

		getShader().cleanup();
		getLoader().cleanup();
	}

	//////////////////////////////////
	// Error Handlers //
	//////////////////////////////////
	private static ErrorHandlerType[] errorHandlers = new ErrorHandlerType[2];

	public static ErrorHandlerType getErrorHandler() {
		return errorHandlers[0];
	}

	//////////////////////////////////
	// Consoles //
	//////////////////////////////////
	private static ConsoleType[] consoles = new ConsoleType[2];

	public static ConsoleType getConsole() {
		return consoles[0];
	}

	//////////////////////////////////
	// Windows //
	//////////////////////////////////
	private static WindowType[] windows = new WindowType[2];

	public static WindowType getWindow() {
		return windows[0];
	}

	//////////////////////////////////
	// Loaders //
	//////////////////////////////////
	private static LoaderType[] loaders = new LoaderType[2];

	public static LoaderType getLoader() {
		return loaders[0];
	}

	//////////////////////////////////
	// Renderer //
	//////////////////////////////////
	private static RendererType[] renderers = new RendererType[2];

	public static RendererType getRenderer() {
		return renderers[0];
	}

	//////////////////////////////////
	// Shader //
	//////////////////////////////////
	private static ShaderType[] shaders = new ShaderType[2];

	public static ShaderType getShader() {
		return shaders[0];
	}
}
