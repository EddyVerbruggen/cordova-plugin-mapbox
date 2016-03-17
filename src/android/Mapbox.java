package com.telerik.plugins.mapbox;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;

import com.mapbox.mapboxsdk.maps.MapView;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;

import org.json.JSONException;
import org.json.JSONObject;

// TODO for screen rotation, see https://www.mapbox.com/mapbox-android-sdk/#screen-rotation
// TODO fox Xwalk compat, see nativepagetransitions plugin
// TODO look at demo app: https://github.com/mapbox/mapbox-gl-native/blob/master/android/java/MapboxGLAndroidSDKTestApp/src/main/java/com/mapbox/mapboxgl/testapp/MainActivity.java
public class Mapbox extends CordovaPlugin {

  public static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
  public static final String COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
  public static final int LOCATION_REQ_CODE = 0;

  public static final int PERMISSION_DENIED_ERROR = 20;

  private static final String MAPBOX_ACCESSTOKEN_RESOURCE_KEY = "mapbox_accesstoken";

  private static final String ACTION_SHOW = "show";
  private static final String ACTION_HIDE = "hide";
  private static final String ACTION_ADD_MARKERS = "addMarkers";
  private static final String ACTION_ADD_MARKER_CALLBACK = "addMarkerCallback";
  private static final String ACTION_ADD_POLYGON = "addPolygon";
  private static final String ACTION_ADD_GEOJSON = "addGeoJSON";
  private static final String ACTION_GET_ZOOMLEVEL = "getZoomLevel";
  private static final String ACTION_SET_ZOOMLEVEL = "setZoomLevel";
  private static final String ACTION_GET_CENTER = "getCenter";
  private static final String ACTION_SET_CENTER = "setCenter";
  private static final String ACTION_GET_TILT = "getTilt";
  private static final String ACTION_SET_TILT = "setTilt";
  private static final String ACTION_ANIMATE_CAMERA = "animateCamera";

  private static float retinaFactor;
  private String accessToken;
  private CallbackContext callback;

//  private boolean showUserLocation;

  @Override
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    this.retinaFactor = this.getRetinaFactor();
    this.accessToken = this.getAccessToken();
  }


  @Override
  public boolean execute(final String action, final CordovaArgs args, final CallbackContext callbackContext) throws JSONException {
    callback = callbackContext;

    if (ACTION_SHOW.equals(action)) {
      final JSONObject options = args.getJSONObject(0);
      this.show(options, callbackContext);
    } else if (ACTION_HIDE.equals(action)) {
//        if (mapView != null) {
//          cordova.getActivity().runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//              ViewGroup vg = (ViewGroup) mapView.getParent();
//              if (vg != null) {
//                vg.removeView(mapView);
//              }
//              callbackContext.success();
//            }
//          });
//        }

    } else if (ACTION_GET_ZOOMLEVEL.equals(action)) {
//        if (mapView != null) {
//          cordova.getActivity().runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//              final double zoomLevel = mapView.getZoom();
//              callbackContext.success("" + zoomLevel);
//            }
//          });
//        }

    } else if (ACTION_SET_ZOOMLEVEL.equals(action)) {
//        if (mapView != null) {
//          cordova.getActivity().runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//              try {
//                final JSONObject options = args.getJSONObject(0);
//                final double zoom = options.getDouble("level");
//                if (zoom >= 0 && zoom <= 20) {
//                  final boolean animated = !options.isNull("animated") && options.getBoolean("animated");
//                  mapView.setZoom(zoom, animated);
//                  callbackContext.success();
//                } else {
//                  callbackContext.error("invalid zoomlevel, use any double value from 0 to 20 (like 8.3)");
//                }
//              } catch (JSONException e) {
//                callbackContext.error(e.getMessage());
//              }
//            }
//          });
//        }

    } else if (ACTION_GET_CENTER.equals(action)) {
//        if (mapView != null) {
//          cordova.getActivity().runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//              final LatLng center = mapView.getLatLng();
//              Map<String, Double> result = new HashMap<String, Double>();
//              result.put("lat", center.getLatitude());
//              result.put("lng", center.getLongitude());
//              callbackContext.success(new JSONObject(result));
//            }
//          });
//        }

    } else if (ACTION_SET_CENTER.equals(action)) {
//        if (mapView != null) {
//          cordova.getActivity().runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//              try {
//                final JSONObject options = args.getJSONObject(0);
//                final boolean animated = !options.isNull("animated") && options.getBoolean("animated");
//                final double lat = options.getDouble("lat");
//                final double lng = options.getDouble("lng");
//                mapView.setLatLng(new LatLng(lat, lng), animated);
//                callbackContext.success();
//              } catch (JSONException e) {
//                callbackContext.error(e.getMessage());
//              }
//            }
//          });
//        }

    } else if (ACTION_GET_TILT.equals(action)) {
//        if (mapView != null) {
//          cordova.getActivity().runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//              final double tilt = mapView.getTilt();
//              callbackContext.success("" + tilt);
//            }
//          });
//        }

    } else if (ACTION_SET_TILT.equals(action)) {
//        if (mapView != null) {
//          cordova.getActivity().runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//              try {
//                final JSONObject options = args.getJSONObject(0);
//                mapView.setTilt(
//                    options.optDouble("pitch", 20),      // default 20
//                    options.optLong("duration", 5000)); // default 5s
//                callbackContext.success();
//              } catch (JSONException e) {
//                callbackContext.error(e.getMessage());
//              }
//            }
//          });
//        }

    } else if (ACTION_ANIMATE_CAMERA.equals(action)) {
//        if (mapView != null) {
//          cordova.getActivity().runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//              try {
//                // TODO check mandatory elements
//                final JSONObject options = args.getJSONObject(0);
//
//                final JSONObject target = options.getJSONObject("target");
//                final double lat = target.getDouble("lat");
//                final double lng = target.getDouble("lng");
//
//                final CameraPosition.Builder builder =
//                    new CameraPosition.Builder()
//                        .target(new LatLng(lat, lng));
//
//                if (options.has("bearing")) {
//                  builder.bearing(((Double)options.getDouble("bearing")).floatValue());
//                }
//                if (options.has("tilt")) {
//                  builder.tilt(((Double)options.getDouble("tilt")).floatValue());
//                }
//                if (options.has("zoomLevel")) {
//                  builder.zoom(((Double)options.getDouble("zoomLevel")).floatValue());
//                }
//
//                mapView.animateCamera(
//                    CameraUpdateFactory.newCameraPosition(builder.build()),
//                    (options.optInt("duration", 15)) * 1000, // default 15 seconds
//                    null);
//
//                callbackContext.success();
//              } catch (JSONException e) {
//                callbackContext.error(e.getMessage());
//              }
//            }
//          });
//        }

    } else if (ACTION_ADD_POLYGON.equals(action)) {
//        cordova.getActivity().runOnUiThread(new Runnable() {
//          @Override
//          public void run() {
//            try {
//              final PolygonOptions polygon = new PolygonOptions();
//              final JSONObject options = args.getJSONObject(0);
//              final JSONArray points = options.getJSONArray("points");
//              for (int i = 0; i < points.length(); i++) {
//                final JSONObject marker = points.getJSONObject(i);
//                final double lat = marker.getDouble("lat");
//                final double lng = marker.getDouble("lng");
//                polygon.add(new LatLng(lat, lng));
//              }
//              mapView.addPolygon(polygon);
//
//              callbackContext.success();
//            } catch (JSONException e) {
//              callbackContext.error(e.getMessage());
//            }
//          }
//        });

    } else if (ACTION_ADD_GEOJSON.equals(action)) {
      cordova.getActivity().runOnUiThread(new Runnable() {
        @Override
        public void run() {
          // TODO implement
          callbackContext.success();
        }
      });

    } else if (ACTION_ADD_MARKERS.equals(action)) {
//        cordova.getActivity().runOnUiThread(new Runnable() {
//          @Override
//          public void run() {
//            try {
//              addMarkers(args.getJSONArray(0));
//              callbackContext.success();
//            } catch (JSONException e) {
//              callbackContext.error(e.getMessage());
//            }
//          }
//        });

    } else if (ACTION_ADD_MARKER_CALLBACK.equals(action)) {
//        this.markerCallbackContext = callbackContext;
//        mapView.setOnInfoWindowClickListener(new MarkerClickListener());

    } else {
      return false;
    }
    return true;
  }

  private void show(final JSONObject options, final CallbackContext callback) {
    if (!this.permissionGranted(COARSE_LOCATION, FINE_LOCATION)) {
      this.requestPermission(COARSE_LOCATION, FINE_LOCATION);
      return;
    }

    if (accessToken == null) {
      callback.error(MAPBOX_ACCESSTOKEN_RESOURCE_KEY + " not set in strings.xml");
      return;
    }

    MapView mapView = this.createMapView(accessToken, options);
    MapInstance.createMap(mapView, new MapInstance.MapCreatedCallback() {
      @Override
      public void onMapReady(final MapInstance map) {
        cordova.getActivity().runOnUiThread(new Runnable() {
          @Override
          public void run() {
            JSONObject resp = new JSONObject();
            try {
              map.configure(options);
              map.show(webView, retinaFactor, options);
              resp.put("id", map.getId());
              callback.success(resp);
              return;
            } catch (JSONException e) {
              e.printStackTrace();
              callback.error("Failed to create map.");
              return;
            }
          }
        });
      }
    });
  }

  private MapView createMapView(String accessToken, JSONObject options) {
    MapView mapView = new MapView(this.webView.getContext());
    mapView.setAccessToken(accessToken);

    try {
  //    final String style = getStyle(options.optString("style"));
  //    final JSONObject center = options.isNull("center") ? null : options.getJSONObject("center");
      final JSONObject margins = options.isNull("margins") ? null : options.getJSONObject("margins");
      final int left = (int) (retinaFactor * (margins == null || margins.isNull("left") ? 0 : margins.getInt("left")));
      final int right = (int) (retinaFactor * (margins == null || margins.isNull("right") ? 0 : margins.getInt("right")));
      final int top = (int) (retinaFactor * (margins == null || margins.isNull("top") ? 0 : margins.getInt("top")));
      final int bottom = (int) (retinaFactor * (margins == null || margins.isNull("bottom") ? 0 : margins.getInt("bottom")));

      // need to do this to register a receiver which onPause later needs
      mapView.onResume();
      mapView.onCreate(null);

      // position the mapView overlay
      int webViewWidth = webView.getView().getWidth();
      int webViewHeight = webView.getView().getHeight();
      final FrameLayout layout = (FrameLayout) webView.getView().getParent();
      FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(webViewWidth - left - right, webViewHeight - top - bottom);
      params.setMargins(left, top, right, bottom);
      mapView.setLayoutParams(params);

      layout.addView(mapView);
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return mapView;
  }

//  private void addMarkers(JSONArray markers) throws JSONException {
//    for (int i=0; i<markers.length(); i++) {
//      final JSONObject marker = markers.getJSONObject(i);
//      final MarkerOptions mo = new MarkerOptions();
//      mo.title(marker.isNull("title") ? null : marker.getString("title"));
//      mo.snippet(marker.isNull("subtitle") ? null : marker.getString("subtitle"));
//      mo.position(new LatLng(marker.getDouble("lat"), marker.getDouble("lng")));
//      mapView.addMarker(mo);
//    }
//  }
//
//  private class MarkerClickListener implements MapView.OnInfoWindowClickListener {
//
//    @Override
//    public boolean onMarkerClick(@NonNull Marker marker) {
//      // callback
//      if (markerCallbackContext != null) {
//        final JSONObject json = new JSONObject();
//        try {
//          json.put("title", marker.getTitle());
//          json.put("subtitle", marker.getSnippet());
//          json.put("lat", marker.getPosition().getLatitude());
//          json.put("lng", marker.getPosition().getLongitude());
//        } catch (JSONException e) {
//          PluginResult pluginResult = new PluginResult(PluginResult.Status.ERROR,
//              "Error in callback of " + ACTION_ADD_MARKER_CALLBACK + ": " + e.getMessage());
//          pluginResult.setKeepCallback(true);
//          markerCallbackContext.sendPluginResult(pluginResult);
//        }
//        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, json);
//        pluginResult.setKeepCallback(true);
//        markerCallbackContext.sendPluginResult(pluginResult);
//        return true;
//      }
//      return false;
//    }
//  }

  private boolean permissionGranted(String... types) {
    if (Build.VERSION.SDK_INT < 23) {
      return true;
    }
    for (final String type : types) {
      if (PackageManager.PERMISSION_GRANTED != ActivityCompat.checkSelfPermission(this.cordova.getActivity(), type)) {
        return false;
      }
    }
    return true;
  }

  protected void showUserLocation() {
    if (permissionGranted(COARSE_LOCATION, FINE_LOCATION)) {
      //noinspection MissingPermission
//      mapView.setMyLocationEnabled(showUserLocation);
    } else {
      requestPermission(COARSE_LOCATION, FINE_LOCATION);
    }
  }


  private void requestPermission(String... types) {
    ActivityCompat.requestPermissions(
        this.cordova.getActivity(),
        types,
        LOCATION_REQ_CODE);
  }

  // TODO
  public void onRequestPermissionResult(int requestCode, String[] permissions, int[] grantResults) throws JSONException {
    for (int r : grantResults) {
      if (r == PackageManager.PERMISSION_DENIED) {
        this.callback.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, PERMISSION_DENIED_ERROR));
        return;
      }
    }
    switch (requestCode) {
      case LOCATION_REQ_CODE:
        break;
    }
  }

//  public void onPause(boolean multitasking) {
//    mapView.onPause();
//  }
//
//  public void onResume(boolean multitasking) {
//    mapView.onResume();
//  }
//
//  public void onDestroy() {
//    mapView.onDestroy();
//  }

  private float getRetinaFactor() {
    DisplayMetrics metrics = new DisplayMetrics();
    this.cordova.getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
    return metrics.density;
  }

  private String getAccessToken() {
    Activity activity = cordova.getActivity();
    Resources res = activity.getResources();
    String packageName = activity.getPackageName();
    int resourceId;
    String accessToken;

    try {
      resourceId = res.getIdentifier(MAPBOX_ACCESSTOKEN_RESOURCE_KEY, "string", packageName);
      accessToken = activity.getString(resourceId);
    } catch (Resources.NotFoundException e) {
      // we'll deal with this when the accessToken property is read, but for now let's dump the error:
      e.printStackTrace();
      throw e;
    }

    return accessToken;
  }
}
