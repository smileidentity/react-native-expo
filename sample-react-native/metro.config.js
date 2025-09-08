const path = require('path');
const { getDefaultConfig } = require('@react-native/metro-config');
// Resolve root package (the library itself)
const pkg = require('../package.json');

const root = path.resolve(__dirname, '..');

/**
 * Metro configuration
 * https://facebook.github.io/metro/docs/configuration
 *
 * @type {import('metro-config').MetroConfig}
 */
const config = getDefaultConfig(__dirname);

// Watch the monorepo root so edits in the library are picked up
config.watchFolders = [root];

// Resolver tweaks for monorepo + Fabric codegen
config.resolver = {
	...(config.resolver || {}),
	// Prefer React Native entry so Metro loads src (with codegen) over compiled lib
	resolverMainFields: ['react-native', 'browser', 'main'],
	// Prevent Metro from walking up and pulling duplicates
	disableHierarchicalLookup: true,
	// Resolve deps from app and workspace to keep a single tree
	nodeModulesPaths: [
		path.join(__dirname, 'node_modules'),
		path.join(root, 'node_modules'),
	],
	// Map singletons and the local package to the repo root
	extraNodeModules: {
		...(config.resolver?.extraNodeModules || {}),
		[pkg.name]: root,
		'react-native': path.join(__dirname, 'node_modules/react-native'),
		react: path.join(__dirname, 'node_modules/react'),
		scheduler: path.join(__dirname, 'node_modules/scheduler'),
	},
};

module.exports = config;
