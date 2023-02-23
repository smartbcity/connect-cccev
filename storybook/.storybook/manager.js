import { addons } from "@storybook/addons";
import {create} from "@storybook/theming";
import logo from "../public/smartb.png";

addons.setConfig({
  theme: create({
    base: "light",
    brandTitle: "SmartB G2",
    brandUrl: "https://docs.smartb.city/g2",
    brandImage: logo,
    brandTarget: "_self",
    appBg: "#FFFEFB",
    fontBase: '"Montserrat", sans-serif',
    colorPrimary: "#353945",
    colorSecondary: "#353945",
  }),
  showToolbar: false,
});
