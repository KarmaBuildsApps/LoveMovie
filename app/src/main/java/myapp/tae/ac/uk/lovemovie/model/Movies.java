package myapp.tae.ac.uk.lovemovie.model;

import java.util.ArrayList;
import java.util.List;

public class Movies {

    private String layout;
    private String title;
    private Object tabs;
    private Object menu;
    private List<Section> sections = new ArrayList<Section>();
    private String id;
    private String icon;

        /**
         *
         * @return
         * The layout
         */
        public String getLayout() {
            return layout;
        }

        /**
         *
         * @param layout
         * The layout
         */
        public void setLayout(String layout) {
            this.layout = layout;
        }

        /**
         *
         * @return
         * The title
         */
        public String getTitle() {
            return title;
        }

        /**
         *
         * @param title
         * The title
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         *
         * @return
         * The tabs
         */
        public Object getTabs() {
            return tabs;
        }

        /**
         *
         * @param tabs
         * The tabs
         */
        public void setTabs(Object tabs) {
            this.tabs = tabs;
        }

        /**
         *
         * @return
         * The menu
         */
        public Object getMenu() {
            return menu;
        }

        /**
         *
         * @param menu
         * The menu
         */
        public void setMenu(Object menu) {
            this.menu = menu;
        }

        /**
         *
         * @return
         * The sections
         */
        public List<Section> getSections() {
            return sections;
        }

        /**
         *
         * @param sections
         * The sections
         */
        public void setSections(List<Section> sections) {
            this.sections = sections;
        }

        /**
         *
         * @return
         * The id
         */
        public String getId() {
            return id;
        }

        /**
         *
         * @param id
         * The id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         *
         * @return
         * The icon
         */
        public String getIcon() {
            return icon;
        }

        /**
         *
         * @param icon
         * The icon
         */
        public void setIcon(String icon) {
            this.icon = icon;
        }

    }